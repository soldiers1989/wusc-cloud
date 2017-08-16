package com.cxc.chat.param;

public class ThumbsUpParam {
	
	private String messageId;//一条朋友圈的id
	
	private Long userId;
	
	private String nickname;
	
	private boolean isAdd; //true:点赞，false：取消点赞



	public boolean isAdd() {
		return isAdd;
	}

	public void setAdd(boolean isAdd) {
		this.isAdd = isAdd;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}


}
