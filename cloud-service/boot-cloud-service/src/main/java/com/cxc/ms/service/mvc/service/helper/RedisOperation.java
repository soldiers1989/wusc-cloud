/**
 * 
 */
package com.cxc.ms.service.mvc.service.helper;

import redis.clients.jedis.Jedis;

/**
 * <pre>
 * @author Leo
 * 2017-4-17
 * </pre>
 */
@FunctionalInterface
public interface RedisOperation {

	/**
	 * 执行jedis相关操作
	 * @param jedis
	 */
	public boolean jedis(Jedis jedis) throws Exception;
}
