/**
 * 
 */
package com.cxc.ms.service.mvc.vo;

/**
 * @author Leo
 *
 */
public class LoginParam {
    private String phone;
    private String password;
    private String os;
    private String model;
    private String romVersion;
    private String province;
    private String city;
    private String clientIdentifier;
    private String terminalType;
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
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
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
	public String getRomVersion() {
		return romVersion;
	}
	public void setRomVersion(String romVersion) {
		this.romVersion = romVersion;
	}
}
