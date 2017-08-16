package com.cxc.chat.param;

import com.cxc.anno.Required;

public class ArticleThumbsUPParam {

	//文章Id
	@Required
	private String articleId;
	
	//一条评论的Id
	@Required
	private String commentId;
	
	//是否点赞 true:点赞   false:取消点赞
	private boolean isAdd;

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public boolean isAdd() {
		return isAdd;
	}

	public void setAdd(boolean isAdd) {
		this.isAdd = isAdd;
	}
}
