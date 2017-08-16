package com.cxc.chat.easemob.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cxc.chat.easemob.model.Result;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;

public class EntityUtil {
	
	private static final Logger log = LoggerFactory.getLogger(EntityUtil.class);
	private static final ObjectMapper objectMapper = initObjectMapper();
	
	public static <T> T toEntity(ClientResponse response, Class<T> clazz) {
		String src = response.getEntity(String.class);
		log.info(src);
		try {
			T t = objectMapper.readValue(src, clazz);
			if (t instanceof Result) {
				((Result) t).setCode(response.getStatus());
			}
			return t;
		} catch (IOException e) {
			log.error("json error!", e);
		}
		return null;
	}
	public static <T> T toEntity(String src, Class<T> clazz) {
		log.info(src);
		try {
			return objectMapper.readValue(src, clazz);
		} catch (IOException e) {
			log.error("json error!", e);
		}
		return null;
	}
	
	public static String toJson(Object obj) {
		if (obj == null)  return "";
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error("json error!", e);
		}
		return "";
	}

	private static ObjectMapper initObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		return objectMapper;
	}
}
