package com.cxc.course.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cxc.course.model.User;

@FeignClient(name = "users", fallback=UserRemoteServiceFail.class)
public interface UserRemoteService {

	@RequestMapping(value="/users/info", method=RequestMethod.GET)
	public User userIfo(@RequestHeader("user_id") Long userId);
}
