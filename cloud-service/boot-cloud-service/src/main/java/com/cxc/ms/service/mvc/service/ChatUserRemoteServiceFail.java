package com.cxc.ms.service.mvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cxc.ms.service.mvc.ret.Result;
import com.cxc.ms.service.mvc.vo.ChatUser;

@Service
public class ChatUserRemoteServiceFail implements ChatUserRemoteService {

	private static final Logger log = LoggerFactory.getLogger(ChatUserRemoteServiceFail.class);
	@Override
	public Result addChatUser(ChatUser... users) {
		log.error("ChatUserRemoteServiceFail!");
		return null;
	}
}
