package com.cxc.chat.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.chat.param.UserSocialInfoParam;
import com.cxc.chat.ret.UsersData;
import com.cxc.chat.service.UserService;
import com.cxc.util.Empty;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 用户信息控制器
 * @author china
 * 2017-6-21
 */
@RestController
@RequestMapping(path="chatUsers")
public class InfoCtrl {

	private static final Logger log = LoggerFactory.getLogger(InfoCtrl.class);
	
	@Resource
	private UserService userService;
	
	@ApiOperation(value="完善聊天相关信息", response=Empty.class, notes="nickname必需，gender必需，其他非必需。gender:0-未知 1-男 2-女 3-其他")
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.PUT)
	public Object editInfo (@RequestHeader("user_id") Long userId, @RequestBody UserSocialInfoParam param) {
		try {
			return userService.updateUserInfo(param, userId);
		} catch (IllegalArgumentException e) {
			return ResultUtil.PARAM_ERROR;
		} catch (Exception e) {
			log.error("InfoCtrl error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据手机号查看相关信息", response=UsersData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.GET, path="{phone}")
	public Object info (@RequestHeader("user_id") Long userId, @PathVariable("phone") String phone) {
		try {
			return userService.userInfo(phone, userId);
		} catch (IllegalArgumentException e) {
			return ResultUtil.PARAM_ERROR;
		} catch (Exception e) {
			log.error("InfoCtrl error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据昵称检索用户列表，支持分页", response=UsersData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.GET, path="search")
	public Object search(@RequestParam String keyword, @RequestParam(value="offset", defaultValue="0") Integer offset, @RequestHeader("user_id") Long userId) {
		try {
			return userService.searchUsers(keyword, offset, userId);
		} catch (Exception e) {
			log.error("InfoCtrl error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
