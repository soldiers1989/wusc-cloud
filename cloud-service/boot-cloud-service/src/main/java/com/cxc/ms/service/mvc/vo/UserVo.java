package com.cxc.ms.service.mvc.vo;

import java.util.Date;

import com.cxc.ms.service.mvc.model.User;

public class UserVo extends User {
	private String token;
    private Long sessionId;
    private Long systemId;
    private String clientIdentifier;
    private String terminalType;
    private Date createTime;
    private Date expireTime;
	public UserVo() {
		super();
	}
	public UserVo(User user) {
		super();
		this.setEmail(user.getEmail());
		this.setMajor(user.getMajor());
		this.setNickname(user.getNickname());
		this.setPassword(user.getPassword());
		this.setPhone(user.getPhone());
		this.setPhotoUrl(user.getPhotoUrl());
		this.setRealName(user.getRealName());
		this.setRegistrationTime(user.getRegistrationTime());
		this.setResume(user.getResume());
		this.setOrganizationId(user.getOrganizationId());
		this.setSno(user.getSno());
		this.setStatus(user.getStatus());
		this.setUserId(user.getUserId());
		this.setUserLevel(user.getUserLevel());
		this.setUserName(user.getUserName());
		this.setUserType(user.getUserType());
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getSessionId() {
		return sessionId;
	}
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}
	public Long getSystemId() {
		return systemId;
	}
	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}
	public String getClientIdentifier() {
		return clientIdentifier;
	}
	public void setClientIdentifier(String clientIdentifier) {
		this.clientIdentifier = clientIdentifier;
	}
	public String getTerminalType() {
		return terminalType;
	}
	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
}
