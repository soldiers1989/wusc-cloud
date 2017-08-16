package com.cxc.vo;

import java.util.Date;

public class PartNode {
	
	private Long partId;

    private Long courseId;

    private Long chapterId;

    private Long sectionId;

    private Long unitId;

    private String partName;

    private Short partType;

    private String pictureUrl;

    private String depict;

    private Long resourceId;

    private String objectiveTestList;

    private String objectiveRightKeyList;

    private String subjectiveTestList;

    private Date sn;
    
    private Boolean isFinish;
    
    private Boolean isSignIn;

	public Long getPartId() {
		return partId;
	}

	public void setPartId(Long partId) {
		this.partId = partId;
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

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public Short getPartType() {
		return partType;
	}

	public void setPartType(Short partType) {
		this.partType = partType;
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

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public String getObjectiveTestList() {
		return objectiveTestList;
	}

	public void setObjectiveTestList(String objectiveTestList) {
		this.objectiveTestList = objectiveTestList;
	}

	public String getObjectiveRightKeyList() {
		return objectiveRightKeyList;
	}

	public void setObjectiveRightKeyList(String objectiveRightKeyList) {
		this.objectiveRightKeyList = objectiveRightKeyList;
	}

	public String getSubjectiveTestList() {
		return subjectiveTestList;
	}

	public void setSubjectiveTestList(String subjectiveTestList) {
		this.subjectiveTestList = subjectiveTestList;
	}

	public Date getSn() {
		return sn;
	}

	public void setSn(Date sn) {
		this.sn = sn;
	}

	public Boolean getIsFinish() {
		return isFinish;
	}

	public void setIsFinish(Boolean isFinish) {
		this.isFinish = isFinish;
	}

	
	public Boolean getIsSignIn() {
		return isSignIn;
	}

	public void setIsSignIn(Boolean isSignIn) {
		this.isSignIn = isSignIn;
	}


}
