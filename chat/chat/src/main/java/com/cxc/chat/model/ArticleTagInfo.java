package com.cxc.chat.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class ArticleTagInfo {
	
	@Field("tag_id")
	private Long tagId;
	
	@Field("tag_name")
	private String tagName;
	
	@Field("tag_icon")
	private String tagIcon;

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagIcon() {
		return tagIcon;
	}

	public void setTagIcon(String tagIcon) {
		this.tagIcon = tagIcon;
	}


}
