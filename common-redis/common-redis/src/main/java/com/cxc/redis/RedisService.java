package com.cxc.redis;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.SerializationUtils;
import com.cxc.redis.param.ParamWrapper;
import com.cxc.redis.param.RedisParam;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("redisProxyService")
public class RedisService {

	private static final Logger log = LoggerFactory.getLogger(RedisService.class);
	
	@Value("${redis.token}")
	private String redisToken;
	@Resource
	private ObjectMapper objectMapper;
	@Resource
	private RedisRemoteService redisRemoteService;
	
	public Object call(Method method, Object[] args) throws Exception{
		RedisParam rp = new RedisParam();
        rp.setMethod(method.getName());
        rp.setValues(args);
        Class<?>[] clazzs = new Class<?>[args.length];
        for (int i = 0; i < args.length; i ++) {
        	clazzs[i] = rimitive(args[i].getClass());
        }
        rp.setClazzs(clazzs);
		String param = Base64Utils.encodeToString(SerializationUtils.serialize(rp));
		ParamWrapper pw = new ParamWrapper();
		pw.setToken(redisToken);
		pw.setParam(param);
		RedisResult res = redisRemoteService.operate(pw);
		if (res == null || res.getCode() != 200) throw new RuntimeException("redis proxy error!");
        log.info("code:{}", res.getCode());
        log.info("data:{}", res.getData());
        return convert(res.getData(), method.getReturnType());
	}
	
	private Class<?> rimitive(Class<?> clazz) {
		if (clazz == Long.class) {
			return Long.TYPE;
		}
		if (clazz == Integer.class) {
			return Integer.TYPE;
		}
		if (clazz == Double.class) {
			return Double.TYPE;
		}
		if (clazz == Float.class) {
			return Float.TYPE;
		}
		if (clazz == Short.class) {
			return Short.TYPE;
		}
		if (clazz == Boolean.class) {
			return Boolean.TYPE;
		}
		if (clazz == Byte.class) {
			return Byte.TYPE;
		}
		if (clazz == Character.class) {
			return Character.TYPE;
		}
		return clazz;
	}
	
	private Object convert(String value, Class<?> clazz) throws JsonParseException, JsonMappingException, IOException {
		if (StringUtils.isBlank(value)) return null;
		if (clazz == Long.class) {
			return Long.parseLong(value);
		}
		if (clazz == Integer.class) {
			return Integer.parseInt(value);
		}
		if (clazz == Double.class) {
			return Double.parseDouble(value);
		}
		if (clazz == Float.class) {
			return Float.parseFloat(value);
		}
		if (clazz == Short.class) {
			return Short.parseShort(value);
		}
		if (clazz == Boolean.class) {
			return Boolean.parseBoolean(value);
		}
		if (clazz == Byte.class) {
			return Byte.parseByte(value);
		}
		if (clazz == Character.class) {
			return value.charAt(0);
		}
		if (clazz == String.class) {
			return value;
		}
		return objectMapper.readValue(value, clazz);
	}
}
