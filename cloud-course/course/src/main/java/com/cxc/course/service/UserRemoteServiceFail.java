package com.cxc.course.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cxc.course.model.User;

@Service
public class UserRemoteServiceFail implements UserRemoteService {

	private static final Logger log = LoggerFactory.getLogger(UserRemoteServiceFail.class);
	
	@Override
	public User userIfo(Long userId) {
		log.error("user Remote service fail!, userId:{}", userId);
		return null;
	}
}
