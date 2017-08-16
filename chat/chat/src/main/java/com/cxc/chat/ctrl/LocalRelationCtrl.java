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

import com.cxc.chat.exception.DuplicateFriendException;
import com.cxc.chat.exception.FriendsCountMaxException;
import com.cxc.chat.exception.IllegalRelationStateException;
import com.cxc.chat.param.RemarkParam;
import com.cxc.chat.ret.UsersData;
import com.cxc.chat.service.LocalRelationService;
import com.cxc.chat.util.RelationResultUtil;
import com.cxc.util.Empty;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 好友及黑名单控制器（本地通讯录）
 * @author china
 * 2017-6-20
 */
@RestController
@RequestMapping("relation")
public class LocalRelationCtrl {

	private static final Logger log = LoggerFactory.getLogger(LocalRelationCtrl.class);
	
	@Resource
	private LocalRelationService localRelationService;
	
	@ApiOperation(value="新增好友(发送或接受好友申请)", response=UsersData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(value="contacts/{friendId}", method=RequestMethod.POST)
	public Object addFriend(@RequestHeader("user_id") Long owner, @PathVariable("friendId") Long friend) {
		try {
			return localRelationService.applyAddFriend(owner, friend);
		} catch(DuplicateFriendException e) { 
			return RelationResultUtil.DuplicateFriend;
		} catch(FriendsCountMaxException e) { 
			return RelationResultUtil.FriendsCountMax;
		} catch(IllegalRelationStateException e) { 
			return RelationResultUtil.IllegalStateWhenAddFriend;
		} catch (Exception e) {
			log.error("RelationCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="删除好友", response=UsersData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(value="contacts/{friendId}", method=RequestMethod.DELETE)
	public Object deleteFriend(@RequestHeader("user_id") Long owner, @PathVariable("friendId") Long friend) {
		try {
			return localRelationService.deleteFriend(owner, friend);
		} catch(IllegalRelationStateException e) { 
			return RelationResultUtil.IllegalStateWhenDeleteFriend;
		} catch (Exception e) {
			log.error("RelationCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="好友申请列表", response=UsersData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(value="apply", method=RequestMethod.GET)
	public Object applyList(@RequestHeader("user_id") Long owner, @RequestParam(value="offset", defaultValue="0") Integer offset) {
		try {
			return localRelationService.applyList(owner, offset);
		} catch (Exception e) {
			log.error("RelationCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="查看好友列表", response=UsersData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(value="contacts", method=RequestMethod.GET)
	public Object friends(@RequestHeader("user_id") Long owner) {
		try {
			return localRelationService.friendsList(owner);
		} catch (Exception e) {
			log.error("RelationCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="给好友添加备注", response=Empty.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(value="remark/{friendId}", method=RequestMethod.POST)
	public Object remark(@RequestHeader("user_id") Long userId, @PathVariable("friendId") Long friendId, @RequestBody RemarkParam remark) {
		try {
			return localRelationService.addRemark(userId, friendId, remark.getRemark());
		} catch (IllegalRelationStateException e) {
			return RelationResultUtil.IllegalStateWhenAddRemark;
		} catch (Exception e) {
			log.error("RelationCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
