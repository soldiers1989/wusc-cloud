package com.cxc.vo;

import java.util.Date;
import java.util.List;

public class SectionNode{

	List<UnitNode> unitNodeList;
	private List<PartNode> partList;
	
	private Long sectionId;

	private Long courseId;

	private Long chapterId;

	private String sectionName;

	private String pictureUrl;

	private String depict;

	private Date sn;

	private Boolean isLeafNode;
	    
	public SectionNode(List<UnitNode> unitNodeList, List<PartNode> partList) {
		super();

		this.unitNodeList = unitNodeList;
		this.partList = partList;
	}
	
	public SectionNode() {
		super();
	}
	

	public List<UnitNode> getUnitNodeList() {
		return unitNodeList;
	}
	public void setUnitNodeList(List<UnitNode> unitNodeList) {
		this.unitNodeList = unitNodeList;
	}

	public List<PartNode> getPartList() {
		return partList;
	}
	public void setPartList(List<PartNode> partList) {
		this.partList = partList;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
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