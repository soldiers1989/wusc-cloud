package com.cxc.system.model;

import java.util.Date;

public class SystemVersion {
	public static final Short STATUS_VALID = 1;
	public static final Short STATUS_INVALID = 0;
	
    private Long systemVersionId;

    private Long systemId;

    private Integer compatibleNo;

    private Integer mainVersion;

    private Integer minorVersion;

    private String versionDesc;

    private String downloadUrl;

    private String qrCodeUrl;

    private String iconUrl;

    private Date created;

    private Short status;

    private String platform;

    public Long getSystemVersionId() {
        return systemVersionId;
    }

    public void setSystemVersionId(Long systemVersionId) {
        this.systemVersionId = systemVersionId;
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public Integer getCompatibleNo() {
        return compatibleNo;
    }

    public void setCompatibleNo(Integer compatibleNo) {
        this.compatibleNo = compatibleNo;
    }

    public Integer getMainVersion() {
        return mainVersion;
    }

    public void setMainVersion(Integer mainVersion) {
        this.mainVersion = mainVersion;
    }

    public Integer getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(Integer minorVersion) {
        this.minorVersion = minorVersion;
    }

    public String getVersionDesc() {
        return versionDesc;
    }

    public void setVersionDesc(String versionDesc) {
        this.versionDesc = versionDesc == null ? null : versionDesc.trim();
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl == null ? null : downloadUrl.trim();
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl == null ? null : qrCodeUrl.trim();
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }
}