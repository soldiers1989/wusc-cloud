package com.cxc.chat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxc.chat.easemob.FriendClient;
import com.cxc.chat.easemob.TokenService;
import com.cxc.chat.easemob.model.UserListResult;
import com.cxc.chat.exception.DuplicateFriendException;
import com.cxc.chat.exception.FriendsCountMaxException;
import com.cxc.chat.exception.IllegalRelationStateException;
import com.cxc.chat.mapper.UserRelationMapper;
import com.cxc.chat.mapper.UserSocialInfoMapper;
import com.cxc.chat.model.UserRelation;
import com.cxc.chat.model.UserRelationKey;
import com.cxc.chat.model.UserSocialInfo;
import com.cxc.chat.ret.UsersData;
import com.cxc.chat.ret.WrapUser;
import com.cxc.util.DateUtil;
import com.cxc.util.Empty;
import com.cxc.util.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 好友及黑名单相关服务（也调用环信接口）
 * @author china
 * 2017-6-20
 */
@Service
public class LocalRelationService {

	private static final Logger log = LoggerFactory.getLogger(LocalRelationService.class);
	
	private static final int friends_count_max = 500;
	
	@Resource
	private TokenService tokenService;
	@Resource
	private FriendClient friendClient;
	@Resource
	private UsersRemoteService usersRemoteService;
	@Resource
	private UserSocialInfoMapper userSocialInfoMapper;
	@Resource
	private UserRelationMapper userRelationMapper;
	
	@Resource
	private MongoDbService mongoDbService;
	
	
	/**
	 * 添加好友申请
	 * @param owner
	 * @param friend
	 * @return
	 * @throws DuplicateFriendException
	 * @throws FriendsCountMaxException
	 * @throws IllegalRelationStateException
	 */
	@Transactional
	public Empty applyAddFriend(Long owner, Long friend) throws DuplicateFriendException, FriendsCountMaxException, IllegalRelationStateException{
		//1.判断用户好友数量是否已达上限  2.判断目前关系 3.判断对方有没有加自己的申请 4.调用环信接口添加好友 5.插入或者更新关系记录，如果对方也有加自己的申请，则还需要更新好友数量  6.返回结果
		//1.判断用户好友数量是否已达上限
		Integer friendsCount = userSocialInfoMapper.selectFriendsCountByUserId(owner);
		if (friendsCount != null && friendsCount >= friends_count_max) {
			throw new FriendsCountMaxException();
		}
		//2.判断目前关系
		UserRelationKey key = new UserRelationKey();
		key.setUserId(owner);
		key.setAnotherUserId(friend);
		UserRelation userRelation = userRelationMapper.selectByPrimaryKey(key);
		if (userRelation != null) {
			switch (userRelation.getType()) {
			case UserRelation.TYPE_FRIEND:
			case UserRelation.TYPE_APPLY:
				return ResultUtil.EMPTY_RESULT;
/*			case UserRelation.TYPE_BLOCK:
				throw new IllegalRelationStateException();*/
			}
		}
		//3.判断对方有没有加自己的申请
		boolean flag = false;//是否对方对我也有加好友申请
		key.setUserId(friend);
		key.setAnotherUserId(owner);
		UserRelation anotherRelation = userRelationMapper.selectByPrimaryKey(key);
		if (anotherRelation != null) {
			flag = anotherRelation.getType() == UserRelation.TYPE_FRIEND || anotherRelation.getType() == UserRelation.TYPE_APPLY;
		}
		// 4.调用环信接口添加好友
		WrapUser aim = usersRemoteService.getUserById(friend);//朋友
		WrapUser self = usersRemoteService.getUserById(owner);//用户自己 
		if (aim == null || self == null) {
			throw new RuntimeException("maybe error user id!");
		}
		UserListResult result = friendClient.addFriend(tokenService.getFullToken(), self.getPhone(), aim.getPhone());
		if (result.getCode() == null || result.getCode() != 200) {
			throw new RuntimeException("add friend error!");
		}
		//5.本地添加好友 步骤：1.userSocialInfo要确保有记录 2.userRelation要确保有记录
		//5.1插入或者更新userSocialInfo
		if (friendsCount == null) {//需要新建记录
			UserSocialInfo info = new UserSocialInfo();
			info.setFriendsCount(flag ? 1 : 0);
			info.setUserId(owner);
			if (userSocialInfoMapper.insertSelective(info) != 1) {
				throw new RuntimeException("add friend error!");
			}
		} else {//需要更新记录，count加1
			if (flag) {
				if (userSocialInfoMapper.incFriendsCountPrimaryKey(owner) != 1) {
					throw new RuntimeException("add friend error!");
				}
			}
		}
		//5.2 插入或更新userRelation
		UserRelation relation = new UserRelation();
		relation.setAnotherUserId(friend);
		relation.setType(flag ? UserRelation.TYPE_FRIEND : UserRelation.TYPE_APPLY);
		relation.setUserId(owner);
		relation.setUpdated(DateUtil.current());
		if (userRelation == null) {//需要新建记录
			if (userRelationMapper.insertSelective(relation) != 1) {
				throw new RuntimeException("add friend error!");
			}
		} else { //需要修改记录
			if (userRelationMapper.updateByPrimaryKeySelective(relation) != 1) {
				throw new RuntimeException("add friend error!");
			}
		}
		//可能需要再更新一条
		if (anotherRelation != null && anotherRelation.getType() == UserRelation.TYPE_APPLY) {
			anotherRelation.setType(UserRelation.TYPE_FRIEND);
			anotherRelation.setUpdated(DateUtil.current());
			if (userRelationMapper.updateByPrimaryKeySelective(anotherRelation) != 1) {
				throw new RuntimeException("add friend error!");
			}
		}
		return ResultUtil.EMPTY_RESULT;
	}
	
	/**
	 * 删除好友
	 * @param owner
	 * @param friend
	 * @return
	 */
	@Transactional
	public UsersData deleteFriend(Long owner, Long friend) {
		/**
		 * 1.判断是不是好友  2.获取用户手机号 3.调用环信接口删除好友 4.本地删除好友并更新好友数量 5.返回结果
		 */
		//1.判断是不是好友
		UserRelationKey key = new UserRelationKey();
		key.setUserId(owner);
		key.setAnotherUserId(friend);
		UserRelation userRelation = userRelationMapper.selectByPrimaryKey(key);
		if (userRelation == null || userRelation.getType() != UserRelation.TYPE_FRIEND) {//不是好友抛出异常
			throw new IllegalRelationStateException();
		}
		//2.获取用户手机号
		WrapUser aim = usersRemoteService.getUserById(friend);//朋友
		WrapUser self = usersRemoteService.getUserById(owner);//用户自己 
		if (aim == null || self == null) {
			throw new RuntimeException("delete friends error!");
		}
		aim.setEaseMobUserId(aim.getPhone());
		//3.调用环信接口删除好友
		UserListResult result = friendClient.deleteFriend(tokenService.getFullToken(), self.getPhone(), aim.getPhone());
		if (result.getCode() == null || result.getCode() != 200) {
			throw new RuntimeException("delete friends error!");
		}
		//4.本地删除好友并更新好友数量
		UserRelation relation = new UserRelation();//修改自己与对方的好友关系
		relation.setAnotherUserId(friend);
		relation.setType(UserRelation.TYPE_NONE);
		relation.setUserId(owner);
		UserRelation anotherRelation = new UserRelation();//修改对方与自己的好友关系
		anotherRelation.setAnotherUserId(owner);
		anotherRelation.setType(UserRelation.TYPE_NONE);
		anotherRelation.setUserId(friend);
		if (userRelationMapper.updateByPrimaryKeySelective(relation) != 1 || userSocialInfoMapper.decFriendsCountPrimaryKey(owner) != 1 
				|| userRelationMapper.updateByPrimaryKeySelective(anotherRelation) != 1 || userSocialInfoMapper.decFriendsCountPrimaryKey(friend) != 1 ) {
			throw new RuntimeException("delete friends error!");
		}
		//5.返回结果
		return usersData(aim);
	}
	
	/**
	 * 好友列表
	 * @param owner
	 * @return
	 */
	public UsersData friendsList(Long owner) {
		/**
		 * 1.查询本地所有的好友id 2.查询这些好友id的信息
		 */
		//1.查询本地所有的好友id
		List<UserRelation> friends = userRelationMapper.selectByUserIdAndType(owner, UserRelation.TYPE_FRIEND);
		if (friends == null || friends.isEmpty()) {
			UsersData data = new UsersData();
			data.setSize(0);
			data.setUsers(new ArrayList<WrapUser>(0));
			return data;
		}
		//2.查询这些好友id的信息并返回
		return addUserInfo(friends, owner);
	}
	
	/**
	 * 好友申请列表
	 * @param owner
	 * @return
	 */
	public UsersData applyList(Long owner, Integer offset) throws Exception{
		//1.查询本地所有的对我的好友申请和我发出的好友申请 2.查询这些好友id的信息 3.返回
		Page<UserRelation> page = PageHelper.offsetPage(offset, 20);
		page.setOrderBy(" created desc ");
		userRelationMapper.selectAllByUserIdAndType(owner, UserRelation.TYPE_APPLY);
		List<UserRelation> applyList = page.toPageInfo().getList();
		//2.查询这些好友id的信息
		if (applyList.isEmpty()) {
			UsersData data = new UsersData();
			data.setSize(0);
			data.setUsers(new ArrayList<WrapUser>(0));
			return data; 
		}
		UsersData data = addUserInfo(applyList, owner);
		return data;
	}
	
	/**
	 * 添加备注
	 * @param owner
	 * @param friend
	 * @param remark
	 * @return
	 */
	public Empty addRemark(Long owner, Long friend, String remark) throws IllegalRelationStateException{
		if (StringUtils.isBlank(remark)) throw new IllegalRelationStateException();
		UserRelation relation = new UserRelation();
		relation.setUserId(owner);
		relation.setAnotherUserId(friend);
		relation.setRemark(remark);
		relation.setUpdated(DateUtil.current());
		if (userRelationMapper.updateByPrimaryKeySelective(relation) != 1) {
			throw new IllegalRelationStateException();
		}
		return ResultUtil.EMPTY_RESULT;
	}
	
	private UsersData addUserInfo(List<UserRelation> list, Long owner) {
		UsersData data = usersRemoteService.getUsersById(list.stream().map(t -> {
			return  t.getAnotherUserId() == owner ? t.getUserId() : t.getAnotherUserId();
		}).collect(Collectors.toList()));
		if (data == null || data.getSize() == null || data.getSize() == 0) {
			throw new RuntimeException("local relation error!");
		}
		Map<Long, UserRelation> relationMap = new HashMap<Long, UserRelation>(list.size() * 2);
		list.stream().forEach( t -> {relationMap.put(t.getAnotherUserId() == owner ? t.getUserId() : t.getAnotherUserId(), t);});
		data.getUsers().stream().forEach( t -> {
			t.setEaseMobUserId(t.getPhone());
			t.setCreated(null);
			UserRelation relation = relationMap.get(t.getUserId());
			if (relation != null) {
				t.setRemark(relation.getRemark());
				t.setCreated(relation.getCreated());
				t.setIsFriend(relation.getType() == UserRelation.TYPE_FRIEND);
				t.setAcceptable(relation.getType() == UserRelation.TYPE_APPLY && relation.getAnotherUserId() == owner);
			}
		});
		return data;
	}
	
	private List<WrapUser> list(WrapUser ... u) {
		List<WrapUser> users = new ArrayList<>(u.length);
		for (WrapUser wu : u) {
			users.add(wu);
		}
		return users;
	}
	
	private UsersData usersData(WrapUser user) {
		UsersData data = new UsersData();
		data.setUsers(list(user));
		data.setSize(1);
		return data;
	}
}
