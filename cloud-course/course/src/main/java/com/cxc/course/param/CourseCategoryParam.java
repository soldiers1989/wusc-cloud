package com.cxc.course.param;

import com.cxc.anno.Range;
import com.cxc.anno.Required;
import com.cxc.anno.StringLength;

public class CourseCategoryParam {
	@Range(min=1, max=Integer.MAX_VALUE)
	@Required
	private Integer classId;
	@Required
	@StringLength(min=2, max=20)
    private String categoryName;
	@StringLength(min=0, max=1000)
    private String pictureUrl;
	@StringLength(min=0, max=2000)
    private String depict;
	@Required
	@Range(min=0, max=Short.MAX_VALUE)
	private Short isLeafNode;
	
	public Short getIsLeafNode() {
		return isLeafNode;
	}

	public void setIsLeafNode(Short isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}
	
}
