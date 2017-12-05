package com.cxc.ms.service.mvc.model;

import java.util.Date;

public class UserSuggestion {
    private Long userSuggestionId;

    private Long userId;

    private Date submitTime;

    private String suggestionType;

    private String suggestionText;

    private String handle;

    private Date handleTime;

    public Long getUserSuggestionId() {
        return userSuggestionId;
    }

    public void setUserSuggestionId(Long userSuggestionId) {
        this.userSuggestionId = userSuggestionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getSuggestionType() {
        return suggestionType;
    }

    public void setSuggestionType(String suggestionType) {
        this.suggestionType = suggestionType == null ? null : suggestionType.trim();
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText == null ? null : suggestionText.trim();
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle == null ? null : handle.trim();
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }
}