package com.cxc.chat.param;

import com.cxc.anno.Required;

public class ArticleCommentParam extends CommentParam {
	//文章Id
	@Required
	private String articleId;
		
	//一条评论的Id
	private String commentId;

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
	

}
