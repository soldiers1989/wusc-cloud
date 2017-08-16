package com.cxc.ms.service.mvc.vo;

import com.cxc.anno.EqualHeader;
import com.cxc.anno.Range;
import com.cxc.anno.Required;
import com.cxc.anno.StringLength;

/**
 * <pre>
 * 完善用户信息参数接收
 * @author Leo
 * 2017-4-19
 * </pre>
 */
public class UserParam {
	@Range(min=1)
	@Required
	@EqualHeader(value="user_id")
    private Long userId;
	@StringLength(max=20)
	private String userName;
	@StringLength(max=20)
    private String nickname;
	@StringLength(max=20)
    private String realName;
	@StringLength(max=40)
    private String email;
	@Range(min=1)
    private Long organizationId;
	@StringLength(max=60)
    private String major;
	@StringLength(max=30)
    private String sno;
	@StringLength(max=1000)
    private String photoUrl;
	@StringLength(max=2000)
    private String resume;
	@StringLength(min=11,max=11)
	private String phone;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
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
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
