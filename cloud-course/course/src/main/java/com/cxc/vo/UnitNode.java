package com.cxc.vo;

import java.util.Date;
import java.util.List;

public class UnitNode{

	List<PartNode> partList;
	
	private Long unitId;

    private Long courseId;

    private Long sectionId;

    private String unitName;

    private Short unitType;

    private String pictureUrl;

    private String depict;

    private Date sn;

    private Boolean isLeafNode;
    
	public UnitNode(List<PartNode> partList) {
		super();

		this.partList = partList;
	}
	
	public UnitNode() {
		super();
	}

	public List<PartNode> getPartList() {
		return partList;
	}
	public void setPartList(List<PartNode> partList) {
		this.partList = partList;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

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

	public Date getSn() {
		return sn;
	}

	public void setSn(Date sn) {
		this.sn = sn;
	}

	public Boolean getIsLeafNode() {
		return isLeafNode;
	}

	public void setIsLeafNode(Boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

}
