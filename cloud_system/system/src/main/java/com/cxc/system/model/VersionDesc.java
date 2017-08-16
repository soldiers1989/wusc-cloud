package com.cxc.system.model;

public class VersionDesc {
    private Long versionDescId;

    private Long versionId;

    private String desc;

    private String pictureUrl;

    public Long getVersionDescId() {
        return versionDescId;
    }

    public void setVersionDescId(Long versionDescId) {
        this.versionDescId = versionDescId;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }
}