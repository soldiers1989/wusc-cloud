package com.cxc.course.model;

import java.util.Date;

public class SubjectiveTest {
    private Long questionId;

    private Long partId;

    private String referenceMaterial;

    private String questions;

    private Short score;

    private String commentOn;

    private Date sn;

    private Date created;

    private Date updated;

    private Long updateUserId;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public String getReferenceMaterial() {
        return referenceMaterial;
    }

    public void setReferenceMaterial(String referenceMaterial) {
        this.referenceMaterial = referenceMaterial == null ? null : referenceMaterial.trim();
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions == null ? null : questions.trim();
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public String getCommentOn() {
        return commentOn;
    }

    public void setCommentOn(String commentOn) {
        this.commentOn = commentOn == null ? null : commentOn.trim();
    }

    public Date getSn() {
        return sn;
    }

    public void setSn(Date sn) {
        this.sn = sn;
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
}