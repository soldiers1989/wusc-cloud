package com.cxc.video.ali;

import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse.VideoMeta;

public class GetVideoPlayAuth {
	private String requestId;
	private String playAuth;
	private VideoMeta videoMeta;
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getPlayAuth() {
		return playAuth;
	}
	public void setPlayAuth(String playAuth) {
		this.playAuth = playAuth;
	}
	public VideoMeta getVideoMeta() {
		return videoMeta;
	}
	public void setVideoMeta(VideoMeta videoMeta) {
		this.videoMeta = videoMeta;
	}
}
