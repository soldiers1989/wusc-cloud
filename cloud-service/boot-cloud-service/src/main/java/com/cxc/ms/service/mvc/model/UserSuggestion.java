package com.cxc.ms.service.mvc.model;

import java.util.Date;

import com.cxc.anno.Required;
import com.cxc.anno.StringLength;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserSuggestion {
	public static final String TYPE_COMMON = "common";
	@JsonIgnore
    private Long userSuggestionId;
	@JsonIgnore
    private Long userId;
    @JsonIgnore
    private Date submitTime;
    @JsonIgnore
    private String suggestionType;
    @StringLength(max=2000)
    @Required
    private String suggestionText;
    @JsonIgnore
    private String handle;
    @JsonIgnore
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