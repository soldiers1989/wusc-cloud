package com.cxc.chat.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cxc.chat.param.UserSocialInfoParam;
import com.cxc.chat.ret.UsersData;
import com.cxc.chat.ret.WrapUser;
import com.cxc.util.ErrorModel;

@Service
public class UsersRemoteServiceFail implements UsersRemoteService {
	private static Logger log = LoggerFactory.getLogger(UsersRemoteServiceFail.class);
	@Override
	public WrapUser getUserById(Long userId) {
		log.error("UsersRemoteServiceFail, userId:{}", userId);
		return null;
	}
	@Override
	public UsersData getUsersByPhone(String... phones) {
		log.error("UsersRemoteServiceFail!");
		return null;
	}
	@Override
	public UsersData getUsersById(List<Long> ids) {
		log.error("UsersRemoteServiceFail!");
		return null;
	}
	@Override
	public ErrorModel editUser(Long userId, UserSocialInfoParam user) {
		log.error("UsersRemoteServiceFail!");
		return null;
	}
	@Override
	public UsersData getUsersByNickname(String nickname, Integer offset) {
		log.error("UsersRemoteServiceFail!");
		return null;
	}
}
