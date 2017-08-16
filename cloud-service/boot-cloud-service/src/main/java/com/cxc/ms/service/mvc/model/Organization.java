package com.cxc.ms.service.mvc.model;

import java.util.Date;

public class Organization {
	
	public static final Short CATEGORY_SCHOOL = 1;
	public static final Short CATEGORY_COMPANY = 2;
	public static final Short CATEGORY_MECHANISM = 3;
	public static final Short CATEGORY_ORGANIZATION = 4;
	
    private Long id;

    private String name;
    
    private String pictureUrl;

    private Short category;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getCategory() {
        return category;
    }

    public void setCategory(Short category) {
        this.category = category;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
}