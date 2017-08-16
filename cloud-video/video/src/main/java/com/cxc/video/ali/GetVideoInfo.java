package com.cxc.video.ali;

import com.aliyuncs.vod.model.v20170321.GetVideoInfoResponse.Video;

public class GetVideoInfo {
	private String requestId;
	private Video video;
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
}
