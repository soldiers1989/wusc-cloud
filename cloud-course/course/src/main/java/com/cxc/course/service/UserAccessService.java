package com.cxc.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.course.model.User;

@Service
public class UserAccessService {
	//private static final Logger log = LoggerFactory.getLogger(UserAccessService.class);
	@Resource
	private UserRemoteService userRemoteService;
	
	public User getUserInfo(Long userId) {
		User user = userRemoteService.userIfo(userId);
		if (user == null || user.getUserId() == null) throw new RuntimeException("user is null or user id is null, user id:" + userId);
		return user;
	}
}
