package com.cxc.chat.ret;

import java.util.List;

import com.cxc.chat.model.ArticleDynamicInfo;

public class ArticleData {

	private List<ArticleDynamicInfo> articles;
	private Long size;
	
	public ArticleData(List<ArticleDynamicInfo> lstArticles, Long size){
		this.articles = lstArticles;
		this.size = size;
	}

	public List<ArticleDynamicInfo> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleDynamicInfo> articles) {
		this.articles = articles;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
}
