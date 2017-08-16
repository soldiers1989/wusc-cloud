package com.cxc.course.model;

import java.util.Date;

public class Unit {
    private Long unitId;

    private Long courseId;

    private Long sectionId;

    private String unitName;

    private Short unitType;

    private String pictureUrl;

    private String depict;

    private Date sn;

    private Boolean isLeafNode;

    private String partIdList;

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
        this.unitName = unitName == null ? null : unitName.trim();
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
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict == null ? null : depict.trim();
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

    public String getPartIdList() {
        return partIdList;
    }

    public void setPartIdList(String partIdList) {
        this.partIdList = partIdList == null ? null : partIdList.trim();
    }
}