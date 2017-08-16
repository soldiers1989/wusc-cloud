package com.cxc.refresh;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

@Aspect
@Component
public class RefreshAspect {
	private static final Logger log = LoggerFactory.getLogger(RefreshAspect.class);
	
	@Value("${spring.application.name}")
	private String appName;
	@Resource
	private Jedis jedis;
	
	private String keyFormat = "college.cache.%s.%s";
	
	@Pointcut("@annotation(com.cxc.refresh.Refresh)")
	public  void aspect() {
    	
    }
	
	@AfterReturning(value="aspect()",argNames="retValue", returning="retValue")
	public Object doAfter(JoinPoint joinPoint, Object retValue){
		try {
			if(joinPoint.getSignature() instanceof MethodSignature) {
				MethodSignature ms = (MethodSignature)joinPoint.getSignature();
				Refresh refresh = ms.getMethod().getAnnotation(Refresh.class);
				if(refresh != null){
					Set<String> keyset = new HashSet<>();
					String key = refresh.key();
					//refresh.key is empty, delete all the app cache, otherwise delete the cache with same key
					if(key.isEmpty()){
						keyset = jedis.keys(String.format(keyFormat, appName,"*"));
					} else {
						keyset = jedis.keys(key);
					}
					
					if(!keyset.isEmpty()){
						keyset.forEach(t->{
							jedis.del(t);
						});
					}
				} 
			}
		} catch(Throwable e){
			log.error("RefreshAspect error", e);
		}
		return retValue;
	}
	
	
	
	

}
