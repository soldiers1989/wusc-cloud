package com.cxc.course.model;

import java.util.Date;

public class Part {
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

    private Date created;

    private Date updated;

    private Long updateUserId;

    private Date sn;

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
        this.partName = partName == null ? null : partName.trim();
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
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict == null ? null : depict.trim();
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
        this.objectiveTestList = objectiveTestList == null ? null : objectiveTestList.trim();
    }

    public String getObjectiveRightKeyList() {
        return objectiveRightKeyList;
    }

    public void setObjectiveRightKeyList(String objectiveRightKeyList) {
        this.objectiveRightKeyList = objectiveRightKeyList == null ? null : objectiveRightKeyList.trim();
    }

    public String getSubjectiveTestList() {
        return subjectiveTestList;
    }

    public void setSubjectiveTestList(String subjectiveTestList) {
        this.subjectiveTestList = subjectiveTestList == null ? null : subjectiveTestList.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getSn() {
        return sn;
    }

    public void setSn(Date sn) {
        this.sn = sn;
    }
}