package com.cxc.chat.easemob;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cxc.chat.easemob.model.UserListResult;
import com.cxc.chat.easemob.util.EntityUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * 环信friend相关操作client
 * @author china
 * 2017-6-14
 */
@Service
public class FriendClient {

	@Value("${cxc.easemob.userUrl}")
	private String url;
	private Client client;
	
	public FriendClient() {
		client = ClientUtil.client;
	}
	/**
	 * 新增好友 {owner_username}/contacts/users/{friend_username}
	 * @param authorization
	 * @param owner
	 * @param friend
	 * @return
	 */
	public UserListResult addFriend(String authorization, String owner, String friend) {
		ClientResponse response = webResource(String.format("%s/contacts/users/%s", owner, friend)).header("Authorization", authorization).post(ClientResponse.class);
		return EntityUtil.toEntity(response, UserListResult.class);
	}
	
	/**
	 * 删除好友
	 * @param authorization
	 * @param owner
	 * @param friend
	 * @return
	 */
	public UserListResult deleteFriend(String authorization, String owner, String friend) {
		ClientResponse response = webResource(String.format("%s/contacts/users/%s", owner, friend)).header("Authorization", authorization).delete(ClientResponse.class);
		return EntityUtil.toEntity(response, UserListResult.class);
	}
	
	/**
	 * 查看好友列表 {owner_username}/contacts/users
	 * 返回的好友list在data属性里
	 * @param authorization
	 * @param owner
	 * @return
	 */
	public UserListResult friendList(String authorization, String owner) {
		ClientResponse response = webResource(String.format("%s/contacts/users", owner)).header("Authorization", authorization).get(ClientResponse.class);
		return EntityUtil.toEntity(response, UserListResult.class);
	}
	
	/**
	 * 查看黑名单列表{owner_username}/blocks/users
	 * 返回的黑名单列表在data属性里
	 * @param authorization
	 * @param owner
	 * @return
	 */
	public UserListResult blockList(String authorization, String owner) {
		ClientResponse response = webResource(String.format("%s/blocks/users", owner)).header("Authorization", authorization).get(ClientResponse.class);
		return EntityUtil.toEntity(response, UserListResult.class);
	}
	
	/**
	 * 新增黑名单{owner_username}/blocks/users
	 * 加成功的username列表在data属性里
	 * @param authorization
	 * @param owner
	 * @param blocks 黑名单列表
	 * @return
	 */
	public UserListResult addBlock(String authorization, String owner, String[] blocks) {
		Map<String, Object> entity = new HashMap<>();
		entity.put("usernames", blocks);
		ClientResponse response = webResource(String.format("%s/blocks/users", owner)).header("Authorization", authorization).entity(EntityUtil.toJson(entity), MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class);
		return EntityUtil.toEntity(response, UserListResult.class);
	}
	
	/**
	 * 从黑名单列表中减人 {owner_username}/blocks/users/{blocked_username}
	 * 减人信息存储在返回结果的entities属性里
	 * @param authorization
	 * @param owner
	 * @param block
	 * @return
	 */
	public UserListResult deleteBlock(String authorization, String owner, String block) {
		ClientResponse response = webResource(String.format("%s/blocks/users/%s", owner, block)).header("Authorization", authorization).delete(ClientResponse.class);
		return EntityUtil.toEntity(response, UserListResult.class);
	}
	
	private WebResource webResource(String path) {
		return client.resource(url + "/" + path);
	}
}
