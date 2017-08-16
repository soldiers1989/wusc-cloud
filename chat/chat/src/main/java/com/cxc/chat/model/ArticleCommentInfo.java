package com.cxc.chat.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class ArticleCommentInfo extends CommentInfo {
	@Field("comment_id")
	private String commentId;
	@Field("thumbs_count")
	private int thumbsCount;
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public int getThumbsCount() {
		return thumbsCount;
	}
	public void setThumbsCount(int thumbsCount) {
		this.thumbsCount = thumbsCount;
	}

}
