package com.cxc.redis.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.redis.param.ParamWrapper;
import com.cxc.redis.service.RedisService;
import com.cxc.util.RedisResult;

@RestController
public class RedisCtrl {

	private static final Logger log = LoggerFactory.getLogger(RedisCtrl.class);
	
	@Resource
	private RedisService redisService;
	
	@RequestMapping(value="operate", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public Object operate(@RequestBody ParamWrapper param, HttpServletResponse resp) {
		try {
			return redisService.operate(param, resp);
		} catch (Exception e) {
			log.error("redis error!", e);
		}
		return new RedisResult(999, null);
	}
}
