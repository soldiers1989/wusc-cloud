package com.cxc.video.ali;

/**
 * 刷新视频上传凭证vo
 * @author wanglei
 */
public class RefreshUploadVideo {
	private String requestId;
	private String uploadAuth;
	private String videoId;
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getUploadAuth() {
		return uploadAuth;
	}
	public void setUploadAuth(String uploadAuth) {
		this.uploadAuth = uploadAuth;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
}
