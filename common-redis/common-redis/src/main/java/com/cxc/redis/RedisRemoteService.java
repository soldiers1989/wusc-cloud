package com.cxc.redis;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cxc.redis.param.ParamWrapper;


@FeignClient(value="redis", fallback=RedisRemoteServiceFail.class)
public interface RedisRemoteService {

	@RequestMapping(value="operate", headers="Accept=application/json; charset=UTF-8", method=RequestMethod.POST)
	public RedisResult operate(@RequestBody ParamWrapper param);
}
