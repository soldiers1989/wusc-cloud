package com.cxc.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cxc.redis.param.ParamWrapper;

@Service("redisRemoteServiceFail")
public class RedisRemoteServiceFail implements RedisRemoteService{

	private static final Logger log = LoggerFactory.getLogger(RedisRemoteServiceFail.class);
	
	public RedisResult operate(ParamWrapper param) {
		log.error("RedisRemoteServiceFail!");
		return null;
	}

}
