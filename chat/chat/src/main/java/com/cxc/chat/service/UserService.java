package com.cxc.chat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxc.chat.easemob.TokenService;
import com.cxc.chat.easemob.UserClient;
import com.cxc.chat.easemob.model.ChatUser;
import com.cxc.chat.easemob.model.UserListResult;
import com.cxc.chat.mapper.UserSocialInfoMapper;
import com.cxc.chat.mapper.UserRelationMapper;
import com.cxc.chat.model.UserRelation;
import com.cxc.chat.model.UserRelationKey;
import com.cxc.chat.model.UserSocialInfo;
import com.cxc.chat.param.UserSocialInfoParam;
import com.cxc.chat.ret.UsersData;
import com.cxc.chat.ret.WrapUser;
import com.cxc.util.Empty;
import com.cxc.util.ErrorModel;
import com.cxc.util.ParamUtil;
import com.cxc.util.PhoneUtil;
import com.cxc.util.ResultUtil;

@Service
public class UserService {

	@Resource
	private UserClient userClient;
	@Resource
	private TokenService tokenService;
	@Resource
	private UserSocialInfoMapper userSocialInfoMapper;
	@Resource
	private UsersRemoteService usersRemoteService;
	@Resource
	private UserRelationMapper userRelationMapper;
	
	/**
	 * 新增聊天用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Object addUser(ChatUser user) throws Exception {
		if (validUser(user)) {
			return userClient.addUser(tokenService.getFullToken(), user.getUsername(), user.getPassword());
		}
		return ResultUtil.PARAM_ERROR;
	}
	/**
	 * 批量新增聊天用户
	 * @param users
	 * @return
	 * @throws Exception
	 */
	public Object addUsers(List<ChatUser> users) throws Exception {
		List<ChatUser> valid = new ArrayList<ChatUser>(users.size());
		for (ChatUser user : users) {
			if (validUser(user)) valid.add(user);
		}
		if (!valid.isEmpty()) {
			return userClient.addUsers(tokenService.getFullToken(), valid);
		}
		return ResultUtil.PARAM_ERROR;
	}
	/**
	 * 判断用户属性是否正常
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private boolean validUser(ChatUser user) throws Exception {
		return ParamUtil.checkParamValid(user, null) && validUsername(user);
	}
	
	private boolean validUsername(ChatUser user) throws Exception {
		return user.getUsername() != null && user.getUsername().matches("[a-zA-Z0-9_\\-\\.]*");
	}
	/**
	 * 查看某用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public UserListResult getUser(String username) throws Exception {
		return userClient.getUser(tokenService.getFullToken(), username);
	}
	/**
	 * 批量查看用户，支持分页
	 * @param cursor
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public UserListResult getUsers(String cursor, Integer limit) throws Exception {
		return userClient.getUsers(tokenService.getFullToken(), cursor, limit);
	}
	
	/**
	 * 删除单个用户
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public UserListResult deleteUser(String username) throws Exception {
		return userClient.deleteUser(tokenService.getFullToken(), username);
	}
	
	/**
	 * 批量删除用户
	 */
	public UserListResult deleteUsers(Integer limit) throws Exception {
		return userClient.deleteUsers(tokenService.getFullToken(), limit);
	}
	/**
	 * 更新密码
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Object updatePassword(ChatUser user) throws Exception {
		if (validUser(user)) {
			return userClient.updatePassword(tokenService.getFullToken(), user.getUsername(), user.getPassword());
		}
		return ResultUtil.PARAM_ERROR;
	}
	/**
	 * 更新用户昵称
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Object updateNickname(ChatUser user) throws Exception {
		if (validUsername(user) && StringUtils.isNotBlank(user.getNickname())) {
			return userClient.updateNickname(tokenService.getFullToken(), user.getUsername(), user.getNickname());
		}
		return ResultUtil.PARAM_ERROR;
	}
	
	/**
	 * 完善用户信息（昵称，性别，签名等）
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public Empty updateUserInfo(UserSocialInfoParam param, Long userId) throws IllegalArgumentException,Exception {
		/**
		 * 1.判断参数有效性 2.插入或者更新数据
		 */
		if (!ParamUtil.checkParamValid(param, null)) {
			throw new IllegalArgumentException();
		}
		if (StringUtils.isNotBlank(param.getNickname())) {
			ErrorModel em = usersRemoteService.editUser(userId, param);
			if (em == null || em.getErrorCode() != null) throw new RuntimeException("updateUserInfo error!");
		}
		UserSocialInfo info = new UserSocialInfo();
		info.setUserId(userId);
		info.setGender(param.getGender());
		if (StringUtils.isNotBlank(param.getCity())) {
			info.setCity(param.getCity());
		}
		if (StringUtils.isNotBlank(param.getCountry())) {
			info.setCountry(param.getCountry());
		}
		if (StringUtils.isNotBlank(param.getProvince())) {
			info.setProvince(param.getProvince());
		}
		if (StringUtils.isNotBlank(param.getSignature())) {
			info.setSignature(param.getSignature());
		}
		if (param.getLatitude() != null) {
			info.setLatitude(param.getLatitude());
		}
		if (param.getLongitude() != null) {
			info.setLongitude(param.getLongitude());
		}
		Integer count = userSocialInfoMapper.selectFriendsCountByUserId(userId);
		if (count == null ? userSocialInfoMapper.insertSelective(info) != 1 : userSocialInfoMapper.updateByPrimaryKeySelective(info) != 1)
			throw new RuntimeException("updateUserInfo error!");
		return ResultUtil.EMPTY_RESULT;
	}
	/**
	 * 查看某个用户所有信息
	 * @param phone
	 * @return
	 */
	public UsersData userInfo(String phone, Long owner) throws Exception{
		if (!PhoneUtil.isValidPhone(phone)) throw new com.cxc.chat.exception.IllegalArgumentException();
		UsersData data = usersRemoteService.getUsersByPhone(phone);
		if (data == null || data.getSize() == null || data.getSize() != 1) throw new RuntimeException("userInfo get error");
		WrapUser user = data.getUsers().get(0);
		UserSocialInfo info = userSocialInfoMapper.selectByPrimaryKey(user.getUserId());
		UserRelationKey key = new UserRelationKey();
		key.setAnotherUserId(user.getUserId());
		key.setUserId(owner);
		UserRelation relation = userRelationMapper.selectByPrimaryKey(key);
		if (relation != null) {
			user.setRemark(relation.getRemark());
			user.setIsFriend(relation.getType() == UserRelation.TYPE_FRIEND);
		}
		copyProperty(user, info);
		return data;
	}
	
	/**
	 * 检索用户
	 * @return
	 * @throws Exception
	 */
	public UsersData searchUsers(String keyword, Integer offset, Long userId) throws Exception {
		//如果是手机号，则查询手机，否则只查询昵称
		UsersData data = null;
		if (PhoneUtil.isValidPhone(keyword)) {
			data = usersRemoteService.getUsersByPhone(keyword);
			if (data.getSize() == 0) data = usersRemoteService.getUsersByNickname(keyword, offset);
		} else {
			data = usersRemoteService.getUsersByNickname(keyword, offset);
		}
		if (data == null || data.getSize() == null) throw new RuntimeException("searchUsers error!");
		if (data.getSize() > 0) {//组装信息
			List<Long> ids = data.getUsers().stream().map(t -> {
				return t.getUserId();
			}).collect(Collectors.toList());
			List<UserSocialInfo> list = userSocialInfoMapper.selectListByPrimaryKey(ids);
			Map<Long, UserSocialInfo> map = new HashMap<>();
			list.stream().forEach(t -> map.put(t.getUserId(), t));
			Set<Long> friendIds = userRelationMapper.selectFriendIdByIds(userId, ids, UserRelation.TYPE_FRIEND);
			data.getUsers().stream().forEach(t -> {
				t.setEaseMobUserId(t.getPhone());
				UserSocialInfo info = map.get(t.getUserId());
				if (info != null) {
					copyProperty(t, info);
				}
				if (friendIds.contains(t.getUserId())) {
					t.setIsFriend(true);
				}
			});
		}
		return data;
	}
	
	private void copyProperty(WrapUser user, UserSocialInfo info) {
	    if (info == null) return;
		user.setCreated(info.getCreated());
		user.setEaseMobUserId(user.getPhone());
		user.setCity(info.getCity());
		user.setCountry(info.getCountry());
		user.setGender(info.getGender());
		user.setProvince(info.getProvince());
		user.setSignature(info.getSignature());
	}
}
