package com.cxc.course.model;


public class LearningProgressRecordUnit {
	
    private Long chapterId;

    private Long sectionId;

    private Long unitId;
    
    private Long partId;

    private Short partType;

    private String objectiveRightKey;
    
    private String objectiveTestResult;

    private Long resourceId;

    private Short attendance;

    private Short exercises;

    private Short examine;

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

	public Long getPartId() {
		return partId;
	}

	public void setPartId(Long partId) {
		this.partId = partId;
	}

	public Short getPartType() {
		return partType;
	}

	public void setPartType(Short partType) {
		this.partType = partType;
	}

	public String getObjectiveRightKey() {
		return objectiveRightKey;
	}

	public void setObjectiveRightKeyList(String objectiveRightKey) {
		this.objectiveRightKey = objectiveRightKey;
	}

	public String getObjectiveTestResult() {
		return objectiveTestResult;
	}

	public void setObjectiveTestResult(String objectiveTestResult) {
		this.objectiveTestResult = objectiveTestResult;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Short getAttendance() {
		return attendance;
	}

	public void setAttendance(Short attendance) {
		this.attendance = attendance;
	}

	public Short getExercises() {
		return exercises;
	}

	public void setExercises(Short exercises) {
		this.exercises = exercises;
	}

	public Short getExamine() {
		return examine;
	}

	public void setExamine(Short examine) {
		this.examine = examine;
	}
	
}
