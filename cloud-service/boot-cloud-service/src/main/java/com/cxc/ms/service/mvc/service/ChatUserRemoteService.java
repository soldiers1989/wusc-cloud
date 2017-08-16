package com.cxc.ms.service.mvc.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cxc.ms.service.mvc.ret.Result;
import com.cxc.ms.service.mvc.vo.ChatUser;

@FeignClient(name="chat", fallback=ChatUserRemoteServiceFail.class)
public interface ChatUserRemoteService {
	
	@RequestMapping(method=RequestMethod.POST, path="/users")
	public Result addChatUser(@RequestBody ChatUser ... users);
}
