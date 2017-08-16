package com.cxc.course.param;

import com.cxc.anno.Range;
import com.cxc.anno.StringLength;

public class CourseCategoryModifyParam {

	@Range(min=1, max=Long.MAX_VALUE)
	private Long classId;
	@StringLength(min=2, max=50)
    private String categoryName;
	 @StringLength(min=0, max=2000)
    private String pictureUrl;
    @StringLength(min=0, max=2000)
    private String depict;
    @Range(min=0, max=Short.MAX_VALUE)
	private Short isLeafNode;
    
	public Short getIsLeafNode() {
		return isLeafNode;
	}

	public void setIsLeafNode(Short isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
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
