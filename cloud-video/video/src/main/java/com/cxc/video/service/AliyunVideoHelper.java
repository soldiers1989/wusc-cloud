package com.cxc.video.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoRequest;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoListRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoListResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoRequest;
import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.UpdateVideoInfoRequest;
import com.aliyuncs.vod.model.v20170321.UpdateVideoInfoResponse;
import com.cxc.video.param.UpdateVideoParam;
import com.cxc.video.ali.CreateUploadVideo;
import com.cxc.video.ali.DeleteVideo;
import com.cxc.video.ali.GetVideoInfo;
import com.cxc.video.ali.GetVideoList;
import com.cxc.video.ali.GetVideoListParam;
import com.cxc.video.ali.GetVideoPlayAuth;
import com.cxc.video.ali.RefreshUploadVideo;
import com.cxc.video.ali.UpdateVideoInfo;

/**
 * 阿里云视频服务
 * @author wanglei
 * 2017-4
 */
@Service
public class AliyunVideoHelper {
	@Resource
	private DefaultAcsClient defaultAcsClient;
	
	/***
	 * <pre>
	 * 创建视频上传任务
	 * @see <a href="https://help.aliyun.com/document_detail/52227.html?spm=5176.doc52833.6.605.GBIqb8">阿里云视频点播-上传凭证</a>
	 * @param fileName 文件名字，运营人员设定
	 * @param fileSize 文件大小，单位b
	 * @return
	 * @throws ServerException
	 * @throws ClientException
	 * </pre>
	 */
	public CreateUploadVideo createUploadVideo(String fileName, Long fileSize) throws ServerException, ClientException{
		CreateUploadVideoRequest request = new CreateUploadVideoRequest();
		request.setFileName(fileName);
		request.setFileSize(fileSize);
		request.setTitle(fileName);
		CreateUploadVideoResponse response = defaultAcsClient.getAcsResponse(request);
		CreateUploadVideo upload = new CreateUploadVideo();
		upload.setUploadAddress(response.getUploadAddress());
		upload.setUploadAuth(response.getUploadAuth());
		upload.setVideoId(response.getVideoId());
		upload.setRequestId(response.getRequestId());
		return upload;
	}
	
	/**
	 * 刷新视频上传凭证
	 * @see <a href="https://help.aliyun.com/document_detail/52227.html?spm=5176.doc52833.6.605.GBIqb8">阿里云视频点播-更新上传凭证</a>
	 * @param videoId 视频id
	 * @return
	 * @throws ServerException
	 * @throws ClientException
	 */
	public RefreshUploadVideo refreshUploadVideo(String videoId) throws ServerException, ClientException {
		RefreshUploadVideoRequest request = new RefreshUploadVideoRequest();
		request.setVideoId(videoId);
		RefreshUploadVideoResponse response = defaultAcsClient.getAcsResponse(request);
		RefreshUploadVideo upload = new RefreshUploadVideo();
		upload.setRequestId(response.getRequestId());
		upload.setUploadAuth(response.getUploadAuth());
		upload.setVideoId(videoId);
		return upload;
	}
	/**
	 * 获取视频信息
	 * @see <a href="https://help.aliyun.com/document_detail/52835.html?spm=5176.doc52833.6.574.GBIqb8">阿里云视频点播-获取视频信息</a>
	 * @param videoId
	 * @return
	 * @throws ServerException
	 * @throws ClientException
	 */
	public GetVideoInfo getVideoInfo(String videoId) throws ServerException, ClientException {
		GetVideoInfoRequest request = new GetVideoInfoRequest();
		request.setVideoId(videoId);
		GetVideoInfoResponse response = defaultAcsClient.getAcsResponse(request);
		GetVideoInfo videoInfo = new GetVideoInfo();
		videoInfo.setRequestId(response.getRequestId());
		videoInfo.setVideo(response.getVideo());
		return videoInfo;
	}
	/***
	 * 更新视频信息
	 * @see <a href="https://help.aliyun.com/document_detail/52836.html?spm=5176.doc52833.6.575.GBIqb8">阿里云视频点播-更新视频</a>
	 * @param info
	 * @return
	 * @throws ServerException
	 * @throws ClientException
	 */
	public UpdateVideoInfo updateVideoInfo(UpdateVideoParam info) throws ServerException, ClientException {
		UpdateVideoInfoRequest request = new UpdateVideoInfoRequest();
		request.setVideoId(info.getVideoId());
		request.setCoverURL(info.getCoverURL());
		request.setTitle(info.getTitle());
		request.setDescription(info.getDescription());
		request.setTags(info.getTags());
		request.setCateId(info.getCateId());
		UpdateVideoInfoResponse response = defaultAcsClient.getAcsResponse(request);
		UpdateVideoInfo videoInfo = new UpdateVideoInfo();
		videoInfo.setRequestId(response.getRequestId());
		return videoInfo;
	}
	/**
	 * 删除视频
	 * @see <a href="https://help.aliyun.com/document_detail/52837.html?spm=5176.doc52836.6.576.xY9Jki">阿里云视频点播-删除视频</a>
	 * @param videoIds 多个视频id，用英文逗号隔开
	 * @return
	 * @throws ClientException 
	 * @throws ServerException 
	 */
	public DeleteVideo deleteVideo(String videoIds) throws ServerException, ClientException {
		DeleteVideoRequest request = new DeleteVideoRequest();
		request.setVideoIds(videoIds);
		DeleteVideoResponse response = defaultAcsClient.getAcsResponse(request);
		DeleteVideo deleteVideo = new DeleteVideo();
		deleteVideo.setRequestId(response.getRequestId());
		return deleteVideo;
	}
	
	/**
	 * 获取视频列表
	 * @see <a href="https://help.aliyun.com/document_detail/52838.html?spm=5176.doc52837.6.577.lTXoBJ">阿里云视频点播-获取视频列表</a>
	 * @param param
	 * @return
	 * @throws ServerException
	 * @throws ClientException
	 */
	public GetVideoList getVideoList(GetVideoListParam param) throws ServerException, ClientException {
		GetVideoListRequest request = new GetVideoListRequest();
		request.setPageNo(param.getPageNo());
		request.setPageSize(param.getPageSize());
		request.setStatus(param.getStatus());
		request.setSortBy(param.getSortBy());
		request.setCateId(param.getCateId());
		GetVideoListResponse response = defaultAcsClient.getAcsResponse(request);
		GetVideoList videoList = new GetVideoList();
		videoList.setRequestId(response.getRequestId());
		videoList.setVideoList(response.getVideoList());
		return videoList;
	}
	/***
	 * 获取视频播放凭证
	 * @see <a href="https://help.aliyun.com/document_detail/52833.html?spm=5176.doc52838.6.579.8Z8jSl">阿里云视频点播-获取播放凭证</a>
	 * @param videoId
	 * @return
	 * @throws ServerException
	 * @throws ClientException
	 */
	public GetVideoPlayAuth getVideoPlayAuth(String videoId) throws ServerException, ClientException {
		GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
		request.setVideoId(videoId);
		GetVideoPlayAuthResponse response = defaultAcsClient.getAcsResponse(request);
		GetVideoPlayAuth auth = new GetVideoPlayAuth();
		auth.setPlayAuth(response.getPlayAuth());
		auth.setRequestId(response.getRequestId());
		auth.setVideoMeta(response.getVideoMeta());
		return auth;
	}
}
