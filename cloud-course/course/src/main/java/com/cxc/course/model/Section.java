package com.cxc.course.model;

import java.util.Date;

public class Section {
    private Long sectionId;

    private Long courseId;

    private Long chapterId;

    private String sectionName;

    private String pictureUrl;

    private String depict;

    private Date sn;

    private Boolean isLeafNode;

    private String partIdList;

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
        this.sectionName = sectionName == null ? null : sectionName.trim();
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