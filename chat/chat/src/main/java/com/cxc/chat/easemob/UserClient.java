package com.cxc.chat.easemob;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cxc.chat.easemob.model.ChatUser;
import com.cxc.chat.easemob.model.Result;
import com.cxc.chat.easemob.model.UserListResult;
import com.cxc.chat.easemob.model.UserResult;
import com.cxc.chat.easemob.util.EntityUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * 环信用户操作服务
 * @see <a href="http://docs.easemob.com/im/100serverintegration/20users">环信用户集成</a>
 * @author china
 * 2017-6-8
 */
@Service
public class UserClient {

	/*@Value("${cxc.easemob.orgName}")
	private String orgName;
	@Value("${cxc.easemob.appName}")
	private String appName;*/
	@Value("${cxc.easemob.userUrl}")
	private String userUrl;
	private Client client;
	
	@PostConstruct
	public void init() {
		client = ClientUtil.client;
	}
	
	private WebResource webResource() {
		return client.resource(userUrl);
	}
	private WebResource webResource(String path) {
		return client.resource(userUrl + "/" + path);
	}
	
	/**
	 * 注册单个用户
	 */
	public UserResult addUser(String authorization, String username, String password) {
		Map<String, String> entity = new HashMap<>();
		entity.put("username", username);
		entity.put("password", password);
		ClientResponse response = webResource().header("Authorization", authorization).entity(EntityUtil.toJson(entity), MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class);
		return EntityUtil.toEntity(response, UserResult.class);
	}
	/**
	 * 批量注册
	 * @param authorization
	 * @param users
	 * @return
	 */
	public UserListResult addUsers(String authorization, List<ChatUser> users) {
		ClientResponse response = webResource().header("Authorization", authorization).entity(EntityUtil.toJson(users), MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class);
		return EntityUtil.toEntity(response, UserListResult.class);
	}
	/**
	 * 获取用户
	 * @param authorization
	 * @param username
	 * @return
	 */
	public UserListResult getUser(String authorization, String username) {
		ClientResponse response = webResource(username).header("Authorization", authorization).get(ClientResponse.class);
		return EntityUtil.toEntity(response, UserListResult.class);
	}
	
	/**
	 * 批量获取用户
	 * @param authorization
	 * @param cursor
	 * @param limit
	 * @return
	 */
	public UserListResult getUsers(String authorization, String cursor, Integer limit) {
		WebResource wr = webResource();
		if (limit != null) {
			wr = wr.queryParam("limit", limit.toString());
		}
		if (cursor != null && cursor.length() > 0) {
			wr = wr.queryParam("cursor", cursor);
		}
		ClientResponse response = wr.header("Authorization", authorization).get(ClientResponse.class);
		return EntityUtil.toEntity(response, UserListResult.class);
	}
	/**
	 * 删除单个用户
	 * @param authorization
	 * @param username
	 * @return
	 */
	public UserListResult deleteUser(String authorization, String username) {
		ClientResponse response = webResource(username).header("Authorization", authorization).delete(ClientResponse.class);
		return EntityUtil.toEntity(response, UserListResult.class);
	}
	
	/**
	 * 批量删除用户
	 * @param authorization
	 * @param username
	 * @return
	 */
	public UserListResult deleteUsers(String authorization, Integer limit) {
		WebResource wr = webResource();
		if (limit != null) {
			wr = wr.queryParam("limit", limit.toString());
		}
		ClientResponse response = wr.header("Authorization", authorization).delete(ClientResponse.class);
		return EntityUtil.toEntity(response, UserListResult.class);
	}
	/**
	 * 更新密码
	 * @param authorization
	 * @param username
	 * @param newpassword
	 * @return
	 */
	public Result updatePassword(String authorization, String username, String newpassword) {
		Map<String, String> entity = new HashMap<>();
		entity.put("newpassword", newpassword);
		ClientResponse response = webResource(username + "/password").header("Authorization", authorization).entity(EntityUtil.toJson(entity), MediaType.APPLICATION_JSON_TYPE).put(ClientResponse.class);
		return EntityUtil.toEntity(response, Result.class);
	}
	/**
	 * 修改用户昵称
	 * @param authorization
	 * @param username
	 * @param nickname
	 * @return
	 */
	public UserListResult updateNickname(String authorization, String username, String nickname) {
		Map<String, String> entity = new HashMap<>();
		entity.put("nickname", nickname);
		ClientResponse response = webResource(username).header("Authorization", authorization).entity(EntityUtil.toJson(entity), MediaType.APPLICATION_JSON_TYPE).put(ClientResponse.class);
		return EntityUtil.toEntity(response, UserListResult.class);
	}
}
