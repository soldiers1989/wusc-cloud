package com.cxc.chat.ret;

import java.util.Date;

/**
 * 封装了用户头像等信息的类
 * @author china
 * 2017-6-14
 */
public class WrapUser {
	private String photoUrl;
	private String username;
	private String easeMobUserId;
	private String nickname;
	private Integer userType; 
	private Boolean activated;
	private Date created;
	private Long userLevel;
	private Long userId;
	private String phone;
	private String remark;
	private Byte gender;
    private String country;
    private String province;
    private String city;
    private String signature;
    private Boolean isFriend;
    private Boolean acceptable;//是否可接受
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEaseMobUserId() {
		return easeMobUserId;
	}
	public void setEaseMobUserId(String easeMobUserId) {
		this.easeMobUserId = easeMobUserId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Boolean getActivated() {
		return activated;
	}
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Long getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(Long userLevel) {
		this.userLevel = userLevel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Byte getGender() {
		return gender;
	}
	public void setGender(Byte gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public Boolean getIsFriend() {
		return isFriend;
	}
	public void setIsFriend(Boolean isFriend) {
		this.isFriend = isFriend;
	}
	public Boolean getAcceptable() {
		return acceptable;
	}
	public void setAcceptable(Boolean acceptable) {
		this.acceptable = acceptable;
	}
}
