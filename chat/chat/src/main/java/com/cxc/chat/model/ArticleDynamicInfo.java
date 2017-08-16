package com.cxc.chat.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.cxc.chat.constants.MongoDbCollection;

@Document(collection=MongoDbCollection.ARTICLE_DYNAMIC_INFO_COLLECTION)
public class ArticleDynamicInfo {
	@Field("_id")
	private String articleId;
	
	@Field("title")
	private String title;
	
	@Field("content")
	private String contentUrl;
	
	@Field("category")
	private List<String> category;
	
	@Field("tag")
	private List<ArticleTagInfo> tag;
	
	@Field("author_id")
	private Long authorId;
	
	@Field("deploy_time")
	private Date deployTime;
	
	@Field("hits")
	private Long hits;
	
	@Field("recommended_product_id")
	private Long recommendedProductId;
	
	@Field("reply")
	private List<ArticleCommentInfo> reply;

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Date getDeployTime() {
		return deployTime;
	}

	public void setDeployTime(Date deployTime) {
		this.deployTime = deployTime;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}


	public List<ArticleTagInfo> getTag() {
		return tag;
	}

	public void setTag(List<ArticleTagInfo> tag) {
		this.tag = tag;
	}

	public Long getHits() {
		return hits;
	}

	public void setHits(Long hits) {
		this.hits = hits;
	}

	public Long getRecommendedProductId() {
		return recommendedProductId;
	}

	public void setRecommendedProductId(Long recommendedProductId) {
		this.recommendedProductId = recommendedProductId;
	}

	public List<ArticleCommentInfo> getReply() {
		return reply;
	}

	public void setReply(List<ArticleCommentInfo> reply) {
		this.reply = reply;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}
	

}
