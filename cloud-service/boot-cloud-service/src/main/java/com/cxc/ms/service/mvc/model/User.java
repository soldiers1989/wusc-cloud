package com.cxc.ms.service.mvc.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User{
	
	public static final Short USERTYPE_STUDENT = 1;
	
	public static final Long USERLEVEL_DEFAULT = 0L;
	
	public static final Short USERSTATUS_ZOMBILE = 0;//刚注册
	public static final Short USERSTATUS_DELETED = -1;//已删除或者封禁的用户
	public static final Short USERSTATUS_COMMON = 1;//待审核的用户
	public static final Short USERSTATUS_PASSED = 2;//审核通过的用户
	
	public static final Short ADMINSTATUS_STOP = 1; //停用的管理员
	
    private Long userId;

    private Short userType;

    private String userName;

    private String nickname;

    private String realName;

    @JsonIgnore
    private String password;

    private String email;

    private Long organizationId;

    private String major;

    private String sno;

    private String photoUrl;

    private Date registrationTime;

    private Long userLevel;

    private Short status;

    private String phone;

    private String resume;
    
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Short getUserType() {
        return userType;
    }
    public void setUserType(Short userType) {
        this.userType = userType;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }
    public String getSno() {
        return sno;
    }
    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }
    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }
    public Date getRegistrationTime() {
        return registrationTime;
    }
    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }
    public Long getUserLevel() {
        return userLevel;
    }
    public void setUserLevel(Long userLevel) {
        this.userLevel = userLevel;
    }
    public Short getStatus() {
        return status;
    }
    public void setStatus(Short status) {
        this.status = status;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
    public String getResume() {
        return resume;
    }
    public void setResume(String resume) {
        this.resume = resume == null ? null : resume.trim();
    }
}

