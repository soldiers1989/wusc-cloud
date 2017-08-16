package com.cxc.course.param;

import com.cxc.anno.Range;
import com.cxc.anno.StringLength;

public class SectionModifyParam {

	@Range(min=1, max=Long.MAX_VALUE)
	private Long courseId;
	@Range(min=1, max=Long.MAX_VALUE)
	private Long chapterId;
	@StringLength(min=2, max=20)
    private String sectionName;
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
