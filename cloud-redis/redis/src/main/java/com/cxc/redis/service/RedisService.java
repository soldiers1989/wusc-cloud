package com.cxc.redis.service;

import java.lang.reflect.Method;
import java.util.HashSet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.internal.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.SerializationUtils;

import com.cxc.redis.param.ParamWrapper;
import com.cxc.redis.param.RedisParam;
import com.cxc.util.RedisResult;
import com.netflix.discovery.util.StringUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis服务，提供redis相关操作
 * @author wanglei
 * 2017-5-3
 */
@Service
public class RedisService {
	
	private static final Logger log = LoggerFactory.getLogger(RedisService.class);
	
	@Resource
	private JedisPool jedisPool;
	@Value("${redis.token}")
	private String redisToken;
	
	/**
	 * 进行redis操作
	 * @param param base64编码的RedisParam对象序列化
	 * @return
	 * @throws Exception
	 */
	public Object operate(ParamWrapper param, HttpServletResponse resp) throws Exception {
		if (!redisToken.equals(param.getToken())) {
			resp.setStatus(401);
			resp.flushBuffer();
			return null;
		}
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			RedisParam rp = (RedisParam) SerializationUtils.deserialize(Base64Utils.decodeFromString(param.getParam()));
			Method m = Jedis.class.getMethod(rp.getMethod(), rp.getClazzs());
			Object ret = m.invoke(jedis, rp.getValues());
			if(ret instanceof HashSet){
				ret = StringHelper.join((HashSet<String>) ret, ",");
			}
			log.warn("xxxxxxxxxxxxxxxxxxxx---redis service ret:{}", ret);
			return new RedisResult(200, ret);
		} finally {
			if (jedis != null) jedis.close();
		}
	}
}
