package com.cxc.chat.easemob.model;
/**
 * 单个用户返回结果
 * @author china
 * 2017-6-8
 */
public class UserResult extends Result {
	private ChatUser entities;
	public ChatUser getEntities() {
		return entities;
	}
	public void setEntities(ChatUser entities) {
		this.entities = entities;
	}
}
