package com.cxc.chat.easemob;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cxc.cache.Cache;
import com.cxc.chat.easemob.model.TokenResult;
import com.cxc.chat.easemob.util.EntityUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Service
public class TokenService {
	
	private static final Logger log = LoggerFactory.getLogger(TokenService.class);
	
	@Value("${cxc.easemob.clientId}")
	private String clientId;
	@Value("${cxc.easemob.clientSecret}")
	private String clientSecret;
	@Value("${cxc.easemob.tokenUrl}")
	private String tokenUrl;
	@Resource
	private UserClient userClient;
	
	/**
	 * 获取token
	 * @return
	 */
	public TokenResult token() {
		Client client = ClientUtil.client;
		WebResource resource = client.resource(tokenUrl);
		Map<String, String> entity = new HashMap<>();
		entity.put("grant_type", "client_credentials");
		entity.put("client_id", clientId);
		entity.put("client_secret", clientSecret);
		ClientResponse response = resource.entity(EntityUtil.toJson(entity), MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class);
		if (response.getStatus() == 200) {
			TokenResult tr = EntityUtil.toEntity(response.getEntity(String.class), TokenResult.class) ;
			if (tr != null && StringUtils.isNotBlank(tr.getAccess_token())) return tr;
		} else {
			error("token", response);
		}
		return null;
	}
	
	/**
	 * 获取完整的token，得加一个前缀
	 * @return
	 */
	@Cache(type=String.class, time=1000*3600*24L, key="college.cache.chat.easemob.fulltoken")
	public String getFullToken() {
		TokenResult tr = token();
		if (tr != null) {
			return String.format("Bearer %s", tr.getAccess_token());
		}
		return null;
	}
	
	private void error(String method, ClientResponse response) {
		log.error(String.format("easemob chat %s status not 200: {}, content:{}", method), response.getStatus(), response.getEntity(String.class));
	}
}
