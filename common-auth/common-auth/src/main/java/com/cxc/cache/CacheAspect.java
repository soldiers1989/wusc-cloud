package com.cxc.cache;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

@Aspect    
@Component 
public class CacheAspect {

	private static final Logger log = LoggerFactory.getLogger(CacheAspect.class);
	private String keyFormat = "college.cache.%s.%s:%s?%s";
	@Value("${spring.application.name}")
	private String appName;
	@Resource
	private ObjectMapper objectMapper;
	@Resource
	private Jedis jedis;
	
    //Controller层切点    
    @Pointcut("@annotation(com.cxc.cache.Cache)")    
    public  void aspect() {
    	
    }
    @Around("aspect()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) {
    	try {
    		if (proceedingJoinPoint.getSignature() instanceof MethodSignature) {
    			MethodSignature ms = (MethodSignature) proceedingJoinPoint.getSignature();
    			Cache cache = ms.getMethod().getAnnotation(Cache.class);
    			if (cache != null) {
    				ServletRequestAttributes sra = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes());
    				HttpServletRequest request = sra.getRequest(); 
    				//HttpServletResponse response = sra.getResponse();
    				String key = cache.key();
					if ("".equals(key)) {
						key = String.format(keyFormat, appName, request.getMethod(), request.getRequestURI(), request.getQueryString());
					} else {
						key = String.format(key, proceedingJoinPoint.getArgs());
					}
    				String value = jedis.get(key);
    				if (value != null && !"".equals(value)) {//查到了缓存
    					try {
    						return objectMapper.readValue(value, cache.type());//反序列化并返回
    					} catch (Exception te) {
    						log.error("cache readValue of json error, json:{}, class:{}", value, cache.type()); //出异常
    						log.error("cache error!", te);
    					}
					}
    				//尚未缓存或者缓存失效
					Object ret = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
					if (ret != null && cache.type().isInstance(ret)) {//返回结果类型符合才缓存
						jedis.set(key, objectMapper.writeValueAsString(ret), "NX", "PX", cache.time());
					}
					return ret;
    			}
    		}
		} catch (Throwable e) {
			log.error("CacheAspect error", e);
		}
    	return null;
    }
}
