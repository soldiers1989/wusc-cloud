package com.cxc.chat.param;

import com.cxc.anno.Range;
import com.cxc.anno.StringLength;

public class UserSocialInfoParam {
	@StringLength(max=40)
	private String nickname;
	@Range(min=0, max=3)
    private Byte gender;
	@StringLength(max=64)
    private String country;
	@StringLength(max=64)
    private String province;
	@StringLength(max=64)
    private String city;
	@StringLength(max=128)
    private String signature;
	@Range(min=-180, max=180)
    private Float longitude;
	@Range(min=-90, max=90)
    private Float latitude;
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
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
