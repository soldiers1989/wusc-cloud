package com.cxc.course.model;

import java.util.Date;

public class Learning {
    private Long learningId;

    private Long userId;

    private Long courseId;

    private Boolean isCollection;

    private Boolean isJoin;

    private Long favoritesId;

    private Float credit;

    private String progressRecord;

    private Date collectTime;

    private Date joinTime;

    private Date updated;

    private Short status;

    private Short progress;

    private Float grade;

    private Short evaluate;

    private Float confCredit;

    public Long getLearningId() {
        return learningId;
    }

    public void setLearningId(Long learningId) {
        this.learningId = learningId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Boolean getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(Boolean isCollection) {
        this.isCollection = isCollection;
    }

    public Boolean getIsJoin() {
        return isJoin;
    }

    public void setIsJoin(Boolean isJoin) {
        this.isJoin = isJoin;
    }

    public Long getFavoritesId() {
        return favoritesId;
    }

    public void setFavoritesId(Long favoritesId) {
        this.favoritesId = favoritesId;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public String getProgressRecord() {
        return progressRecord;
    }

    public void setProgressRecord(String progressRecord) {
        this.progressRecord = progressRecord == null ? null : progressRecord.trim();
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getProgress() {
        return progress;
    }

    public void setProgress(Short progress) {
        this.progress = progress;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Short getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Short evaluate) {
        this.evaluate = evaluate;
    }

    public Float getConfCredit() {
        return confCredit;
    }

    public void setConfCredit(Float confCredit) {
        this.confCredit = confCredit;
    }
}