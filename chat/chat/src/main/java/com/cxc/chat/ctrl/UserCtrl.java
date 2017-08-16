package com.cxc.chat.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.chat.easemob.model.ChatUser;
import com.cxc.chat.easemob.model.Result;
import com.cxc.chat.easemob.model.UserListResult;
import com.cxc.chat.service.UserService;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("users")
public class UserCtrl {

	private static final Logger log = LoggerFactory.getLogger(UserCtrl.class);
	
	@Resource
	private UserService userService;
	
	@ApiOperation(value="新增聊天用户", response=UserListResult.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.POST)
	public Object users(@RequestBody List<ChatUser> users) {
		try {
			return userService.addUsers(users);
		} catch (Exception e) {
			log.error("UserCtrl error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="查看{username}聊天用户", response=UserListResult.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.GET, path="{username}")
	public Object users(@PathVariable("username") String username) {
		try {
			return userService.getUser(username);
		} catch (Exception e) {
			log.error("UserCtrl error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="查看批量聊天用户", response=UserListResult.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.GET)
	public Object users(@RequestParam(value="cursor", required=false) String cursor, @RequestParam(value="limit", required=false) Integer limit) {
		try {
			return userService.getUsers(cursor, limit);
		} catch (Exception e) {
			log.error("UserCtrl error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="删除{username}聊天用户", response=UserListResult.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.DELETE, path="{username}")
	public Object usersDelete(@PathVariable("username") String username) {
		try {
			return userService.deleteUser(username);
		} catch (Exception e) {
			log.error("UserCtrl error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="批量删除聊天用户", response=UserListResult.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.DELETE)
	public Object users(@RequestParam(value="limit") Integer limit) {
		try {
			return userService.deleteUsers(limit);
		} catch (Exception e) {
			log.error("UserCtrl error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="修改用户密码", response=Result.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.PUT, path="password")
	public Object password(@RequestBody ChatUser user) {
		try {
			return userService.updatePassword(user);
		} catch (Exception e) {
			log.error("UserCtrl error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="修改用户昵称", response=UserListResult.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.PUT)
	public Object nickname(@RequestBody ChatUser user) {
		try {
			return userService.updateNickname(user);
		} catch (Exception e) {
			log.error("UserCtrl error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
