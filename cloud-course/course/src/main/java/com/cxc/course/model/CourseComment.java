package com.cxc.course.model;

import java.util.Date;

public class CourseComment {
    private Long commentId;

    private Long courseId;

    private Long userId;

    private String title;

    private String pictureUrl;

    private String conntent;

    private String underwrite;

    private Date created;

    private Date updated;

    private String photoUrl;

    private String nickname;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public String getConntent() {
        return conntent;
    }

    public void setConntent(String conntent) {
        this.conntent = conntent == null ? null : conntent.trim();
    }

    public String getUnderwrite() {
        return underwrite;
    }

    public void setUnderwrite(String underwrite) {
        this.underwrite = underwrite == null ? null : underwrite.trim();
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }
}