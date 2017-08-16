package com.cxc.chat.model;

public class UserRelationKey {
    private Long userId;

    private Long anotherUserId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAnotherUserId() {
        return anotherUserId;
    }

    public void setAnotherUserId(Long anotherUserId) {
        this.anotherUserId = anotherUserId;
    }
}