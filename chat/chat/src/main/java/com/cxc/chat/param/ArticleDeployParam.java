package com.cxc.chat.param;

import java.util.Date;
import java.util.List;

import com.cxc.anno.Required;

import com.cxc.chat.model.ArticleCategoryInfo;
import com.cxc.chat.model.ArticleTagInfo;

public class ArticleDeployParam {
	@Required
	private String title;
	
	@Required
	private String contentUrl;
	
	@Required
	private List<String> category;
	
	private List<ArticleTagInfo> tag;
	
	@Required
	private Long authorId;
	
	private Date deployTime;
	
	private Long hits;
	
	private Long recommendedProductId;

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

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}

}
