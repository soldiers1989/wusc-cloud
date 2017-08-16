package com.cxc.video.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cxc.video.model.User;

@FeignClient(name="users", fallback=UserRemoteServiceFail.class)
public interface UserRemoteService {

	@RequestMapping(path="/users/info", method={RequestMethod.GET})
	public User userIfo(@RequestHeader("user_id") Long userId);
}
