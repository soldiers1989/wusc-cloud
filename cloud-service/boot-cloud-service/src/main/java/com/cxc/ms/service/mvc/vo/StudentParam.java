package com.cxc.ms.service.mvc.vo;

import com.cxc.anno.Range;
import com.cxc.anno.StringLength;

public class StudentParam {
	@StringLength(max=20)
	private String userName;
	@StringLength(max=40)
    private String email;
	@Range(min=1)
    private Long organizationId;
	@StringLength(max=60)
    private String major;
	@StringLength(max=30)
    private String sno;
	@StringLength(min=11,max=11)
	private String phone;
	private String password;
	@StringLength(max=40)
	private String nickname;
	@Range(min=-1)
	private Short status;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		this.major = major;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
}
