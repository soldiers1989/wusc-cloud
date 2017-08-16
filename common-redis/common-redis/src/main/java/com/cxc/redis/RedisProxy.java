package com.cxc.redis;

import java.lang.reflect.Method;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

@Component
public class RedisProxy implements MethodInterceptor {
	@Resource
	private RedisService redisProxyService;
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		return redisProxyService.call(method, args);
	}
}
