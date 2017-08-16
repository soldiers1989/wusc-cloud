package com.cxc.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import net.sf.cglib.proxy.Enhancer;
import redis.clients.jedis.Jedis;

/**
 * @author Leo
 *
 */
@Configuration
public class RedisConfig {
	
	@Value("${redis.token}")
	private String redisToken;
	
	@Bean
	public Jedis jedis(RestTemplate restTemplate, RedisProxy RedisProxy) {  
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Jedis.class);
        //回调方法的参数为代理类对象CglibProxy，最后增强目标类调用的是代理类对象CglibProxy中的intercept方法  
        enhancer.setCallback(RedisProxy);  
        // 此刻，base不是单纯的目标类，而是增强过的目标类  
        Jedis jedis = (Jedis) enhancer.create();
        return jedis;
    } 
}
