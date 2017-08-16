package com.cxc.chat.param;

import java.util.Date;

public class CommentParam {
	
	private String messageId;//一条朋友圈的id
	
	private Long replyUserId;
	
	private String replyNickName;
	
	private String replyPhotoUrl;
	
	private Long replyToUserId;
	
	private String replyToNickName;
	
	private String replyToPhotoUrl;
	
	private String commentText;
	
	private Date commentTime;
	
	private boolean isAdd; //true:增加一条评论，false：删除一条评论


	public Long getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(Long replyUserId) {
		this.replyUserId = replyUserId;
	}

	public String getReplyNickName() {
		return replyNickName;
	}

	public void setReplyNickName(String replyNickName) {
		this.replyNickName = replyNickName;
	}

	public String getReplyPhotoUrl() {
		return replyPhotoUrl;
	}

	public void setReplyPhotoUrl(String replyPhotoUrl) {
		this.replyPhotoUrl = replyPhotoUrl;
	}

	public Long getReplyToUserId() {
		return replyToUserId;
	}

	public void setReplyToUserId(Long replyToUserId) {
		this.replyToUserId = replyToUserId;
	}

	public String getReplyToNickName() {
		return replyToNickName;
	}

	public void setReplyToNickName(String replyToNickName) {
		this.replyToNickName = replyToNickName;
	}

	public String getReplyToPhotoUrl() {
		return replyToPhotoUrl;
	}

	public void setReplyToPhotoUrl(String replyToPhotoUrl) {
		this.replyToPhotoUrl = replyToPhotoUrl;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public boolean isAdd() {
		return isAdd;
	}

	public void setAdd(boolean isAdd) {
		this.isAdd = isAdd;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	
	

}
