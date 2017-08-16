package com.cxc.chat.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.chat.model.FriendsDynamicInfo;
import com.cxc.chat.param.CommentParam;
import com.cxc.chat.param.FriendDeployParam;
import com.cxc.chat.param.ThumbsUpParam;
import com.cxc.chat.service.MongoDbService;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path="mongodb")
public class MongoDbCtrl {
	private static final Logger log = LoggerFactory.getLogger(MongoDbCtrl.class);
	
	@Resource
	MongoDbService mongoDbService;
	
	@ApiOperation(value="查看我的朋友圈信息，包括我的全部好友发布的所有朋友圈信息,支持分页，每页显示10条朋友圈", response=FriendsDynamicInfo.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="getFriendsInfo/{owner}", method=RequestMethod.GET)
	public Object getFriendsInfo(@PathVariable(value="owner",required=true) Long owner, @RequestParam(value="offset",required=false) Integer offset){
		try {
			return mongoDbService.getAllFriendsDynamicInfo(owner,offset);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			log.error("MongoDbCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="查看某个用户发布的所有的朋友圈信息，支持分页，每页显示10条朋友圈", response=FriendsDynamicInfo.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="getFriendsInfoById/{userId}", method=RequestMethod.GET)
	public Object getFriendsInfoById(@PathVariable(value="userId",required=true) Long userId,@RequestParam(value="offset",required=false) Integer offset){
		try {
			return mongoDbService.getFriendsDynamicInfoByUserId(userId,offset);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			log.error("MongoDbCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="发布朋友圈",response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="deploy", method=RequestMethod.POST)
	public Object deployFriendsInfo(@RequestBody FriendDeployParam friendParam){
		try {
			return mongoDbService.insertFrientsDynamicInfo(friendParam);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			log.error("MongoDbCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	
	@ApiOperation(value="删除当前用户朋友圈信息", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="removeFriendsInfo/{id}", method=RequestMethod.DELETE)
	public Object removeFriendsInfo(@PathVariable(value="id",required=true) String id){
		try {
			return mongoDbService.removeFriendnfo(id);
		} catch (Exception e) {
			log.error("MongoDbCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}

	@ApiOperation(value="增加/删除一条评论信息，message_Id:一条朋友圈信息的唯一标识，必填",response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true)
	})
	@RequestMapping(path="commentFriends", method=RequestMethod.PUT)
	public Object commentFriends(@RequestBody CommentParam param){
		try {
			return mongoDbService.commentFriends(param);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="点赞/取消点赞,message_Id:一条朋友圈信息的唯一标识，必填;add:true点赞，false：取消点赞",response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true)
	})
	@RequestMapping(path="thumbsUp", method=RequestMethod.PUT)
	public Object thumbsUp(@RequestBody ThumbsUpParam param){
		try {
			return mongoDbService.thumbsUp(param);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			log.error("MongoDbCtrl erro!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	
	
	
	
	
}
