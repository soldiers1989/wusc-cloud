package com.cxc.chat.easemob.model;

import java.util.List;
/**
 * 用户列表返回结果
 * @author china
 * 2017-6-8
 */
public class UserListResult extends Result {
	private List<ChatUser> entities;
	private String[] data;
	public List<ChatUser> getEntities() {
		return entities;
	}
	public void setEntities(List<ChatUser> entities) {
		this.entities = entities;
	}
	public String[] getData() {
		return data;
	}
	public void setData(String[] data) {
		this.data = data;
	}
}
