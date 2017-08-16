package com.cxc.course.model;

import java.util.Date;

public class ObjectiveTest {
    private Long questionId;

    private Long partId;

    private Short questionType;

    private String question;

    private String choices;

    private String rightKey;

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

    public Short getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Short questionType) {
        this.questionType = questionType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices == null ? null : choices.trim();
    }

    public String getRightKey() {
        return rightKey;
    }

    public void setRightKey(String rightKey) {
        this.rightKey = rightKey == null ? null : rightKey.trim();
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