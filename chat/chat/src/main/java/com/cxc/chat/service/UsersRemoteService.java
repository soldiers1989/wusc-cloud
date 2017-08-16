package com.cxc.chat.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cxc.chat.param.UserSocialInfoParam;
import com.cxc.chat.ret.UsersData;
import com.cxc.chat.ret.WrapUser;
import com.cxc.util.ErrorModel;

@FeignClient(name="users", fallback=UsersRemoteServiceFail.class)
public interface UsersRemoteService {
	@RequestMapping(path="/users/getUserById/{userId}", method=RequestMethod.GET)
	public WrapUser getUserById(@PathVariable("userId") Long userId);
	@RequestMapping(path="/users/users/phones", method=RequestMethod.GET)
	public UsersData getUsersByPhone(@RequestParam(value="phones") String ... phones);
	@RequestMapping(path="/users/users/ids", method=RequestMethod.GET)
	public UsersData getUsersById(@RequestParam(value="ids") List<Long> ids);
	@RequestMapping(path="/users/editUser/{userId}", method=RequestMethod.PUT)
	public ErrorModel editUser(@PathVariable(value="userId",required=true) Long userId, @RequestBody UserSocialInfoParam user);
	@RequestMapping(value="/users/users/nickname", method=RequestMethod.GET)
	public UsersData getUsersByNickname(@RequestParam("nickname") String nickname, @RequestParam(value="offset") Integer offset);
}
