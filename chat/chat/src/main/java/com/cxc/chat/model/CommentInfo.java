package com.cxc.chat.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class CommentInfo {
//	@Transient
//	private UserBasicInfo commentator;
//	@Transient
//	private UserBasicInfo replyTo;
	
	@Field("reply_user_id")
	private Long replyUserId;
	
	@Field("reply_nickname")
	private String replyNickName;
	
	@Field("reply_photo_url")
	private String replyPhotoUrl;
	
	@Field("reply_to_user_id")
	private Long replyToUserId;
	
	@Field("reply_to_nickname")
	private String replyToNickName;
	
	@Field("reply_to_photo_url")
	private String replyToPhotoUrl;
	
	@Field("reply_text")
	private String commentText;
	
	@Field("reply_time")
	private Date commentTime;

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

}
