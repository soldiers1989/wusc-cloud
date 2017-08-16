package com.cxc.course.param;

import com.cxc.anno.Range;
import com.cxc.anno.StringLength;

public class UnitModifyParam {
	
	@Range(min=1, max=Long.MAX_VALUE)
	private Long courseId;
	@Range(min=1, max=Long.MAX_VALUE)
	private Long sectionId;
	@StringLength(min=2, max=100)
    private String unitName;
	//UnitType废弃
	@Range(min=0, max=Short.MAX_VALUE)
    private Short unitType;
	@StringLength(min=0, max=1000)
    private String pictureUrl;
	@StringLength(min=0, max=2000)
    private String depict;
	private Boolean isLeafNode;
	@StringLength(min=0, max=100)
	private String partIdList;


	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Short getUnitType() {
		return unitType;
	}

	public void setUnitType(Short unitType) {
		this.unitType = unitType;
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

	public Boolean getIsLeafNode() {
		return isLeafNode;
	}

	public void setIsLeafNode(Boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

	public String getPartIdList() {
		return partIdList;
	}

	public void setPartIdList(String partIdList) {
		this.partIdList = partIdList;
	}
	
}
