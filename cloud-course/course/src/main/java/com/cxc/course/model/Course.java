package com.cxc.course.model;

import java.util.Date;

public class Course {
    private Long courseId;

    private Integer categoryId;

    private String courseName;

    private String tutorId;

    private String depict;

    private String iconUrl;

    private String pictureUrl;

    private Date created;

    private Date updated;

    private Long updateUserId;

    private Short recommendedLevel;

    private Long clickRate;

    private Long participantsNum;

    private Short attendanceGrade;

    private Short exercisesGrade;

    private Short examineGrade;

    private Short passingGrade;

    private Boolean isLeafNode;

    private String partIdList;

    private Date sn;

    private Short learningTargetNumber;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId == null ? null : tutorId.trim();
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict == null ? null : depict.trim();
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
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

    public Short getRecommendedLevel() {
        return recommendedLevel;
    }

    public void setRecommendedLevel(Short recommendedLevel) {
        this.recommendedLevel = recommendedLevel;
    }

    public Long getClickRate() {
        return clickRate;
    }

    public void setClickRate(Long clickRate) {
        this.clickRate = clickRate;
    }

    public Long getParticipantsNum() {
        return participantsNum;
    }

    public void setParticipantsNum(Long participantsNum) {
        this.participantsNum = participantsNum;
    }

    public Short getAttendanceGrade() {
        return attendanceGrade;
    }

    public void setAttendanceGrade(Short attendanceGrade) {
        this.attendanceGrade = attendanceGrade;
    }

    public Short getExercisesGrade() {
        return exercisesGrade;
    }

    public void setExercisesGrade(Short exercisesGrade) {
        this.exercisesGrade = exercisesGrade;
    }

    public Short getExamineGrade() {
        return examineGrade;
    }

    public void setExamineGrade(Short examineGrade) {
        this.examineGrade = examineGrade;
    }

    public Short getPassingGrade() {
        return passingGrade;
    }

    public void setPassingGrade(Short passingGrade) {
        this.passingGrade = passingGrade;
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

    public Date getSn() {
        return sn;
    }

    public void setSn(Date sn) {
        this.sn = sn;
    }

    public Short getLearningTargetNumber() {
        return learningTargetNumber;
    }

    public void setLearningTargetNumber(Short learningTargetNumber) {
        this.learningTargetNumber = learningTargetNumber;
    }
}