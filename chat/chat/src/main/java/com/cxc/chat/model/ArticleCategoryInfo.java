package com.cxc.chat.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class ArticleCategoryInfo {
	
	@Field("category_id")
	private Long categoryId;
	
	@Field("category_name")
	private String categoryName;
	
	@Field("category_parent_id")
	private Long categoryParentId;
	
	@Field("category_parent_name")
	private String categoryParentName;
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getCategoryParentId() {
		return categoryParentId;
	}
	public void setCategoryParentId(Long categoryParentId) {
		this.categoryParentId = categoryParentId;
	}
	public String getCategoryParentName() {
		return categoryParentName;
	}
	public void setCategoryParentName(String categoryParentName) {
		this.categoryParentName = categoryParentName;
	}


}
