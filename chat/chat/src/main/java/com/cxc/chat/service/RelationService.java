package com.cxc.chat.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cxc.chat.easemob.FriendClient;
import com.cxc.chat.easemob.TokenService;
import com.cxc.chat.easemob.model.UserListResult;
import com.cxc.chat.ret.UsersData;
import com.cxc.chat.ret.WrapUser;
import com.cxc.util.ErrorModel;

/**
 * 好友及黑名单增删查服务
 * @author china
 * 2017-6-14
 */
@Service
public class RelationService {

	private static final Logger log = LoggerFactory.getLogger(RelationService.class);
	
	@Resource
	private TokenService tokenService;
	@Resource
	private FriendClient friendClient;
	@Resource
	private UsersRemoteService usersRemoteService;
	
	/**
	 * 新增好友
	 * @param owner
	 * @param friend
	 * @return
	 */
	public Object addFriend(String owner, String friend) {
		/**
		 * 1.调用环信接口 2.调用用户服务，获取用户信息 3.信息整合，并返回
		 */
		Object result = checkResult(friendClient.addFriend(tokenService.getFullToken(), owner, friend));
		if (result instanceof UserListResult) {
			return addUserInfo((UserListResult) result);
		}  else {
			return result;
		}
	}
	/**
	 * 删除好友
	 * @param owner
	 * @param friend
	 * @return
	 */
	public Object deleteFriend(String owner, String friend) {
		return checkResult(friendClient.deleteFriend(tokenService.getFullToken(), owner, friend));
	}
	/**
	 * 查看好友列表
	 * @param owner
	 * @return
	 */
	public Object friendList(String owner) {
		/**
		 * 1.调用环信接口 2.调用用户服务，获取用户信息 3.整合信息，并返回
		 */
		Object result = checkResult(friendClient.friendList(tokenService.getFullToken(), owner));
		if (result instanceof UserListResult) {
			return addUserInfo((UserListResult) result);
		}
		return result;
	}
	
	private UsersData addUserInfo(UserListResult result) {
		try {
			String[] phones = ((UserListResult) result).getData();
			UsersData data =  null;
			if (phones != null && phones.length > 0) {
				data = usersRemoteService.getUsersByPhone(phones);
			} else {
				data = usersRemoteService.getUsersByPhone(result.getEntities().get(0).getUsername());
			}
			List<WrapUser> list = data.getUsers();
			if (list != null && !list.isEmpty()) {
				for (WrapUser user : list) {
					user.setEaseMobUserId(user.getPhone());
				}
			}
			return data;
		} catch (Exception e) {
			log.error("usersRemoteService error!", e);
		}
		String[] phones = ((UserListResult) result).getData();
		List<WrapUser> list = new ArrayList<>(phones.length);
		for (int i = 0; i < phones.length; i ++) {
			WrapUser user = new WrapUser();
			list.add(user);
			user.setUsername(phones[i]);
			user.setPhone(phones[i]);
		}
		UsersData data = new UsersData();
		data.setUsers(list);
		data.setSize(list.size());
		return data;
	}
	/**
	 * 黑名单列表
	 * @param owner
	 * @return
	 */
	public Object blockList(String owner) {
		Object result = checkResult(friendClient.blockList(tokenService.getFullToken(), owner));
		if (result instanceof UserListResult) {
			return addUserInfo((UserListResult) result);
		}
		return result;
	}
	/**
	 * 添加黑名单
	 * @param owner
	 * @param blocks
	 * @return
	 */
	public Object addBlock(String owner, String[] blocks) {
		return checkResult(friendClient.addBlock(tokenService.getFullToken(), owner, blocks));
	}
	/**
	 * 删除黑名单
	 * @param owner
	 * @param block
	 * @return
	 */
	public Object deleteBlock(String owner, String block) {
		return checkResult(friendClient.deleteBlock(tokenService.getFullToken(), owner, block));
	}
	
	private Object checkResult(UserListResult result) {
		if (result.getCode() != null && result.getCode() == 200) {
			return result;
		} else {
			return new ErrorModel(result.getCode() == null ? "999": result.getCode().toString(), result.getError());
		}
	}
}
