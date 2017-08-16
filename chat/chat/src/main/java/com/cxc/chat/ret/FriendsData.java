package com.cxc.chat.ret;

import java.util.List;

import com.cxc.chat.model.FriendsDynamicInfo;

public class FriendsData {
	private List<FriendsDynamicInfo> friends;
	private Long size;
	
	public FriendsData(List<FriendsDynamicInfo> lstFriends, Long size){
		this.friends = lstFriends;
		this.size = size;
	}
	
	public List<FriendsDynamicInfo> getFriends() {
		return friends;
	}
	public void setFriends(List<FriendsDynamicInfo> friends) {
		this.friends = friends;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

}
