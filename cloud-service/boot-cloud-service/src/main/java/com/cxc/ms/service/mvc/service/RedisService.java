package com.cxc.ms.service.mvc.service;


import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cxc.ms.service.mvc.service.helper.RedisOperation;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.Jedis;

@Service
public class RedisService {

	private static final Logger log = LoggerFactory.getLogger(RedisService.class);
	
	@Resource
	private Jedis jedis;
	
	@Resource
	private ObjectMapper objectMapper;
	
	public boolean redis(RedisOperation operation) throws Exception {
		return operation.jedis(jedis);
	}
	
	public boolean removeKey(byte[] key) {
		Long ret = jedis.del(key);
		return ret != null && ret == 1L;
	}
	
	public <T> T readObject(String key, Class<T> clazz) {
		String ret = jedis.get(key);
		if (ret != null && ret.length() > 0) {
			try {
				return objectMapper.readValue(ret, clazz);
			} catch (Exception e) {
				log.error("parse {} to Class {} error!", ret, clazz);
				log.error("parseObject", e);
			}
		} else{
			log.info("{} does not exist", key);
		}
		return null;
	}
	
	public String writeObject(String key, Object object) {
		try {
			String  value = objectMapper.writeValueAsString(object);
			String ret = jedis.set(key, value);
			if ("OK".equals(ret == null ? null : ret.trim())) {
				return value;
			}
		} catch (Exception e) {
			log.error("write {} to redis key {} error!", object, key);
			log.error("writeObject", e);
		}
		return null;
	}
}

