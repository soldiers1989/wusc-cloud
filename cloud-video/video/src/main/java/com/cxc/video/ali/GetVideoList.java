package com.cxc.video.ali;

import java.util.List;

import com.aliyuncs.vod.model.v20170321.GetVideoListResponse.Video;

public class GetVideoList {
	private String requestId;
	private List<Video> videoList;
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public List<Video> getVideoList() {
		return videoList;
	}
	public void setVideoList(List<Video> videoList) {
		this.videoList = videoList;
	}
}
