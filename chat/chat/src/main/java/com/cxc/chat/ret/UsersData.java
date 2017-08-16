package com.cxc.chat.ret;

import java.util.List;

public class UsersData {
	private List<WrapUser> users;
	private Integer size;
	public List<WrapUser> getUsers() {
		return users;
	}
	public void setUsers(List<WrapUser> users) {
		this.users = users;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
}
