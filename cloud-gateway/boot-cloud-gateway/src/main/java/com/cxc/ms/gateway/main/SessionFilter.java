package com.cxc.ms.gateway.main;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cxc.ms.gateway.main.model.Session;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import redis.clients.jedis.Jedis;

/**
 * cxc.college.zuul.session.allow: 
 * @author Leo
 *
 */
@Component
public class SessionFilter extends ZuulFilter  {
    private static Logger log = LoggerFactory.getLogger(SessionFilter.class);
    
    private static final String COLLEGE_ROLE = "College_Role";
    private static final String REAL_IP = "Real_Ip";
    
    @Value("${cxc.college.zuul.session.allow.url.get}")
    private String[] allowGet;
    
    @Value("${cxc.college.zuul.session.allow.url.post}")
    private String[] allowPost;
    
    @Value("${cxc.college.zuul.session.allow.startWith.get}")
    private String[] allowStartWithGet;
    
    private Set<String> allowSetGet = new HashSet<>(100);
    private Set<String> allowSetPost = new HashSet<>(10);
    
    @Value("${college.session.expire}")
	private Long sessionExpire;
    @Value("${college.session.redis.key}")
	private String redisSessionKey;
    
    @Resource
    private Jedis jedis;
    
    @Resource
    private ObjectMapper objectMapper;
    
    @PostConstruct
    public void init() {
    	for (String str : allowGet) {
    		allowSetGet.add(str);
    	}
    	for (String str : allowPost) {
    		allowSetPost.add(str);
    	}
    	objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
    
    
    @Override
    public String filterType() {
        return "pre";
    }
    @Override
    public int filterOrder() {
        return 0;
    }
    @Override
    public boolean shouldFilter() {
    	RequestContext ctx = RequestContext.getCurrentContext();
    	HttpServletRequest request = ctx.getRequest();
    	log.info("add header: {}={}", REAL_IP, request.getRemoteAddr());
    	ctx.addZuulRequestHeader(REAL_IP, request.getRemoteAddr());
    	String uri = request.getRequestURI();
    	if ("GET".equals(request.getMethod())) {//如果是get
        	if (allowSetGet.contains(uri)) {
        		return false;	
        	}
        	for (String pre : allowStartWithGet) {
        		if (uri.startsWith(pre)) return false;
        	}
    	} else if ("POST".equals(request.getMethod())) {//如果是post
        	if (allowSetPost.contains(uri)) {
        		return false;	
        	}
    	}
        return true;
    }
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (!isTokenValid(request)) {
        	ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        return null;
    }
    /**
     * 检查valid是否有效
     * @param request
     * @return
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    private boolean isTokenValid(HttpServletRequest request){
    	String token = request.getHeader("token");
    	if (token != null) {
    		try {
    			if (checkUserIdEqual(token, request, "user_id")) {
    				return true;
    			}
			} catch (Exception e) {
				log.error("check token error!", e);
			} 
    	}
    	String adminToken = request.getHeader("admin_token");
    	if (adminToken != null) {
    		try {
    			if (checkUserIdEqual(adminToken, request, "admin_user_id")) {
    				return true;
    			}
			} catch (Exception e) {
				log.error("check admin token error!", e);
			}
    	}
    	return false;
    }
    
    private boolean checkUserIdEqual(String token, HttpServletRequest request, String userIdTag) throws JsonParseException, JsonMappingException, IOException {
    	Long userId = Long.parseLong(request.getHeader(userIdTag));
    	String key = String.format(redisSessionKey, token);
		String json = jedis.get(key);
		if (json != null) {
			Session session= objectMapper.readValue(json, Session.class);
			if (session.getUserId() == userId) {
    			jedis.pexpire(key, sessionExpire);
    			if (session.getRoles() != null && !session.getRoles().isEmpty()) {
    				String roleHeader = objectMapper.writeValueAsString(session.getRoles());
    				log.info("add header: {}={}", COLLEGE_ROLE, roleHeader);
    				RequestContext.getCurrentContext().addZuulRequestHeader(COLLEGE_ROLE, roleHeader);
    			}
    			return true;
    		}
		}
		return false;
    }
}