package com.cxc.chat.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cxc.chat.easemob.model.UserListResult;
import com.cxc.chat.ret.UsersData;
import com.cxc.chat.service.RelationService;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 用户关系控制器
 * @author china
 * 2017-6-14
 */
@Deprecated
public class RelationCtrl {
	
	private static final Logger log = LoggerFactory.getLogger(RelationCtrl.class);
	
	@Resource
	private RelationService relationService;
	
	@ApiOperation(value="新增好友", response=UsersData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(value="{owner}/contacts/{friend}", method=RequestMethod.POST)
	public Object addFriend(@PathVariable("owner") String owner, @PathVariable("friend") String friend) {
		try {
			return relationService.addFriend(owner, friend);
		} catch (Exception e) {
			log.error("RelationCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	@ApiOperation(value="删除好友", response=UserListResult.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(value="{owner}/contacts/{friend}", method=RequestMethod.DELETE)
	public Object delFriend(@PathVariable("owner") String owner, @PathVariable("friend") String friend) {
		try {
			return relationService.deleteFriend(owner, friend);
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
	@RequestMapping(value="{owner}/contacts", method=RequestMethod.GET)
	public Object friends(@PathVariable("owner") String owner) {
		try {
			return relationService.friendList(owner);
		} catch (Exception e) {
			log.error("RelationCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="查看黑名单列表", response=UsersData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(value="{owner}/blocks", method=RequestMethod.GET)
	public Object blocks(@PathVariable("owner") String owner) {
		try {
			return relationService.blockList(owner);
		} catch (Exception e) {
			log.error("RelationCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增黑名单", response=UserListResult.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(value="{owner}/blocks", method=RequestMethod.POST)
	public Object addBlock(@PathVariable("owner") String owner, @RequestBody String[] blocks) {
		try {
			return relationService.addBlock(owner, blocks);
		} catch (Exception e) {
			log.error("RelationCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="删除黑名单", response=UserListResult.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(value="{owner}/blocks/{block}", method=RequestMethod.DELETE)
	public Object deleteBlock(@PathVariable("owner") String owner, @PathVariable("block") String block) {
		try {
			return relationService.deleteBlock(owner, block);
		} catch (Exception e) {
			log.error("RelationCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
