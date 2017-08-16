package com.cxc.ms.service.mvc.model;

public class Verification {
	
	public static final Short STATUS_UNCONSUMED = 0;
	public static final Short STATUS_CONSUMED = 1;
	
    private Long verificationId;

    private String phone;

    private String verificationCode;

    private Long expire;

    private Short status;

    private Long updated;

    public Long getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(Long verificationId) {
        this.verificationId = verificationId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode == null ? null : verificationCode.trim();
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }
}