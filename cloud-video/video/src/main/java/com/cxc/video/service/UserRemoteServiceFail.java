package com.cxc.video.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cxc.exp.BusinessException;
import com.cxc.video.model.User;

@Service("userRemoteServiceFail")
public class UserRemoteServiceFail implements UserRemoteService {

	private static final Logger log = LoggerFactory.getLogger(UserRemoteServiceFail.class);
	
	@Override
	public User userIfo(Long userId) {
		log.error("UserRemoteServiceFail, userId:{}", userId);
		throw new BusinessException();
	}
}
