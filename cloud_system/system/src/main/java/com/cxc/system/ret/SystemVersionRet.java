package com.cxc.system.ret;

public class SystemVersionRet {
    private String versionDesc;
    private String downloadUrl;
    private String qrCodeUrl;
    private String iconUrl;
    private Boolean update;//是否有更新
    private Boolean forceUpdate;//是否强制更新
	public String getVersionDesc() {
		return versionDesc;
	}
	public void setVersionDesc(String versionDesc) {
		this.versionDesc = versionDesc;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public String getQrCodeUrl() {
		return qrCodeUrl;
	}
	public void setQrCodeUrl(String qrCodeUrl) {
		this.qrCodeUrl = qrCodeUrl;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public Boolean getUpdate() {
		return update;
	}
	public void setUpdate(Boolean update) {
		this.update = update;
	}
	public Boolean getForceUpdate() {
		return forceUpdate;
	}
	public void setForceUpdate(Boolean forceUpdate) {
		this.forceUpdate = forceUpdate;
	}
}
