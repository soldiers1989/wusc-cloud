package com.cxc.chat.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.cxc.chat.mapper.UserSocialInfoMapper;
import com.cxc.chat.model.CommentInfo;
import com.cxc.chat.model.FriendsDynamicInfo;
import com.cxc.chat.model.LocationInfo;
import com.cxc.chat.model.UserBasicInfo;
import com.cxc.chat.model.UserExtendInfo;
import com.cxc.chat.model.UserSocialInfo;
import com.cxc.chat.param.CommentParam;
import com.cxc.chat.param.FriendDeployParam;
import com.cxc.chat.param.ThumbsUpParam;
import com.cxc.chat.ret.FriendsData;
import com.cxc.chat.ret.WrapUser;
import com.cxc.util.Empty;
import com.cxc.util.ResultUtil;
import com.mongodb.WriteResult;

@Service
public class MongoDbService {
	@Resource
	MongoTemplate mongoTemplate;
	
	@Resource
	private LocalRelationService localRelationService;
	
	@Resource
	private UserSocialInfoMapper userSocialInfoMapper;
	
	@Resource
	private UsersRemoteService usersRemoteService;
	
	public Empty insertFrientsDynamicInfo(FriendDeployParam param) throws Exception {
		FriendsDynamicInfo friendsInfo = new FriendsDynamicInfo();
		WrapUser wrapUser = usersRemoteService.getUserById(param.getUserId());//用户自己 
		UserSocialInfo info = userSocialInfoMapper.selectByPrimaryKey(param.getUserId());
		if(wrapUser == null || info == null){
			throw new RuntimeException("the user is not exist!");
		}
		friendsInfo.setUserId(param.getUserId());
		friendsInfo.setEaseMobUserId(param.getEaseMobUserId());
		friendsInfo.setPhotoUrl(wrapUser.getPhotoUrl());
		friendsInfo.setSharedPhotos(param.getSharedPhotos());
		friendsInfo.setDynamicDepict(param.getDynamicDepict());
		friendsInfo.setCurrentLocation(new LocationInfo("point", param.getCoordinates()));
		friendsInfo.setGender(info.getGender());
		friendsInfo.setPublic(param.isPublic());
		friendsInfo.setNickname(wrapUser.getNickname());
		friendsInfo.setDeployTime(param.getDeployTime());
		friendsInfo.setWorkLocation(new LocationInfo("point", info.getLongitude(), info.getLatitude()));
		mongoTemplate.insert(friendsInfo);
		return ResultUtil.EMPTY_RESULT;
	}
	
	/**
	 * 查看某个用户发布的所有的朋友圈信息
	 * @param userId
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public Object getFriendsDynamicInfoByUserId(Long userId, Integer offset) throws Exception {
		if(offset == null){
			offset = 0;
		}
		Query query=new Query(Criteria.where("user_id").is(userId));
		query.with(new Sort(new Order(Direction.DESC, "deploy_time")));
		query.skip(offset);
		query.limit(10);
		List<FriendsDynamicInfo> lstResults =  mongoTemplate.find(query, FriendsDynamicInfo.class);
		long total = mongoTemplate.count(query, FriendsDynamicInfo.class);
		return new FriendsData(lstResults, total); 
	}
	
	
	/**
	 * 查看我的朋友圈信息，包括我的全部好友发布的所有朋友圈信息
	 * @param owner
	 * @return
	 * @author linmei.yan
	 * @return 
	 * @return 
	 */
	public Object getAllFriendsDynamicInfo(Long owner, Integer offset) throws Exception{
		if(offset == null ){
			offset = 0;
		}
		List<WrapUser> lstFriends = localRelationService.friendsList(owner).getUsers();
		if(lstFriends == null){
			lstFriends = new ArrayList<>();
		}
		
		//将自己也加入到好友中
		List<FriendsDynamicInfo> lstResults = new ArrayList<>();
		List<Long> lstUserId = new ArrayList<>();
		lstUserId.add(owner);
		lstFriends.forEach(t->{
			lstUserId.add(t.getUserId());
		});
		Query query=new Query(Criteria.where("user_id").in(lstUserId));
		query.with(new Sort(new Order(Direction.DESC, "deploy_time")));
		query.skip(offset);
		query.limit(10);
		lstResults.addAll(mongoTemplate.find(query, FriendsDynamicInfo.class));
		long total = mongoTemplate.count(query, FriendsDynamicInfo.class);
//		lstFriends.forEach(t->{
//			Query query=new Query(Criteria.where("user_id").is(t.getUserId()));
//			query.with(new Sort(new Order(Direction.DESC, "deploy_time")));  
//			lstResults.addAll(mongoTemplate.find(query, FriendsDynamicInfo.class));
//		});
		return new FriendsData(lstResults, total);
	}
	
	/**
	 * 增加/删除一条评论信息
	 * @param param
	 * @return
	 * @author linmei.yan
	 */
	public Object commentFriends(CommentParam param) throws Exception{
		//根据id获取一条要点评的朋友圈
		FriendsDynamicInfo info = getFriendDynamicInfoById(param.getMessageId());
		if(info == null){
			throw new RuntimeException("getFriendDynamicInfoById error");
		}
		List<CommentInfo> lstComments = info.getReply();
		if(lstComments == null ){
			lstComments = new ArrayList<>();
		}
		if(param.isAdd()){
			CommentInfo addComment = new CommentInfo();
			addComment.setReplyUserId(param.getReplyUserId());
			addComment.setReplyToUserId(param.getReplyToUserId());
			addComment.setReplyNickName(param.getReplyNickName());
			addComment.setReplyToNickName(param.getReplyToNickName());
			addComment.setReplyPhotoUrl(param.getReplyPhotoUrl());
			addComment.setReplyToPhotoUrl(param.getReplyToPhotoUrl());
			addComment.setCommentText(param.getCommentText());
			addComment.setCommentTime(param.getCommentTime());
			lstComments.add(addComment);
		} else {
			//delete the comment
			lstComments = lstComments.stream().filter((t)->t.getReplyUserId() != param.getReplyUserId() || t.getReplyToUserId() != param.getReplyToUserId()).collect(Collectors.toList());
		}
		Query query = new Query(Criteria.where("_id").is(param.getMessageId()));  
        Update update = Update.update("reply", lstComments); 
        if(mongoTemplate.updateMulti(query, update, FriendsDynamicInfo.class).getN() != 1){
        	return ResultUtil.SYSTEM_ERROR;
        }
        return ResultUtil.EMPTY_RESULT;
	}
	
	/**
	 * 根据_id获取朋友圈信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public FriendsDynamicInfo getFriendDynamicInfoById(String id){
		//Query query=new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findById(id, FriendsDynamicInfo.class);
	}
	
	/**
	 * 点赞/取消点赞
	 * @param param
	 * @return
	 * @author linmei.yan
	 */
	public Object thumbsUp(ThumbsUpParam param) throws Exception{
		//根据id获取一条要点评的朋友圈
		FriendsDynamicInfo info = getFriendDynamicInfoById(param.getMessageId());
		if(info == null){
			throw new RuntimeException("getFriendDynamicInfoById error");
		}
		List<UserBasicInfo> thumbsUp = info.getThumbsUp();
		if(thumbsUp == null){
			thumbsUp = new ArrayList<>();
		}
		if(param.isAdd()){
			UserBasicInfo thumb = new UserBasicInfo();
			thumb.setUserId(param.getUserId());
			thumb.setNickname(param.getNickname());
			thumbsUp.add(thumb);
		} else {
			//delete the comment
			thumbsUp = thumbsUp.stream().filter((t)-> t.getUserId() != param.getUserId()).collect(Collectors.toList());
		}
		Query query = new Query(Criteria.where("_id").is(param.getMessageId()));  
        Update update = Update.update("thumbs_up", thumbsUp); 
        if(mongoTemplate.updateMulti(query, update, FriendsDynamicInfo.class).getN() != 1){
        	return ResultUtil.SYSTEM_ERROR;
        }
        return ResultUtil.EMPTY_RESULT;		
	}

	/**
	 * 删除当前用户的朋友圈一条信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Empty removeFriendnfo(String id) throws Exception{
		Query query = Query.query(Criteria.where("_id").is(id));
		WriteResult result = mongoTemplate.remove(query, FriendsDynamicInfo.class);
		if(result.getN() != 1){
			throw new RuntimeException("delete FriendsInfo error!");
		}
		return ResultUtil.EMPTY_RESULT;
	}
}
