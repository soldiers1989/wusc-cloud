package com.cxc.ms.service.mvc.vo;

import com.cxc.anno.Required;
import com.cxc.anno.StringLength;

public class PasswordParam {
	@Required
	@StringLength(min=11, max=11)
	private String mobile;
	@Required
	@StringLength(min=6, max=12)
	private String passwordNew;
	@Required
	@StringLength(min=6, max=6)
	private String verificationCode;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPasswordNew() {
		return passwordNew;
	}
	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
}
