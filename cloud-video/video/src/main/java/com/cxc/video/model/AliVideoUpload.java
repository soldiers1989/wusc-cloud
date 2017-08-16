package com.cxc.video.model;

import java.util.Date;

public class AliVideoUpload {
	/**
	 * 上传状态：Uploading(上传中) Success(上传成功) Fail(上传失败) Unknown(未知)
	 */
	public static final String STATUS_UPLOADING = "Uploading";
	public static final String STATUS_SUCCESS = "Success";
	public static final String STATUS_FAIL = "Fail";
	public static final String STATUS_UNKNOWN = "Unknown";
    private Long uploadId;

    private String videoId;

    private String uploadAddress;

    private String uploadAuth;

    private String requestId;

    private Date createTime;

    private String status;

    private Boolean deleteFlag;

    private Long createId;

    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    public String getUploadAddress() {
        return uploadAddress;
    }

    public void setUploadAddress(String uploadAddress) {
        this.uploadAddress = uploadAddress == null ? null : uploadAddress.trim();
    }

    public String getUploadAuth() {
        return uploadAuth;
    }

    public void setUploadAuth(String uploadAuth) {
        this.uploadAuth = uploadAuth == null ? null : uploadAuth.trim();
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }
}