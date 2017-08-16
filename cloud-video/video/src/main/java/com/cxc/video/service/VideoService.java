package com.cxc.video.service;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cxc.exp.BusinessException;
import com.cxc.util.DateUtil;
import com.cxc.util.ParamUtil;
import com.cxc.util.ResultUtil;
import com.cxc.video.ali.CreateUploadVideo;
import com.cxc.video.ali.GetVideoInfo;
import com.cxc.video.ali.RefreshUploadVideo;
import com.cxc.video.ali.UpdateVideoInfo;
import com.cxc.video.mapper.AliVideoMapper;
import com.cxc.video.mapper.AliVideoUploadMapper;
import com.cxc.video.model.AliVideo;
import com.cxc.video.model.AliVideoUpload;
import com.cxc.video.param.UpdateVideoParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 视频相关service
 * @author wanglei
 * 2017-4-27
 */
@Service
public class VideoService {
	
	private static final Logger log = LoggerFactory.getLogger(VideoService.class);
	
	private static final DateFormat COMMON_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Resource
	private AliyunVideoHelper aliyunVideoHelper;
	@Resource
	private AliVideoUploadMapper aliVideoUploadMapper;
	@Resource
	private AliVideoMapper aliVideoMapper;
	@Resource
	private ObjectMapper objectMapper;
	
	/**
	 * 创建视频上传凭证
	 * @param fileName
	 * @param fileSize
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public Object uploadVideoCreate(String fileName, Long fileSize, Long userId) throws Exception {
		/**
		 * 1.判断参数有效性 2.发送请求给阿里云 3.插入数据 4.返回结果
		 */
		//1.判断参数有效性
		if (StringUtils.isBlank(fileName) || fileName.length() > 128 || fileSize <= 0) {
			return ResultUtil.PARAM_ERROR;
		}
		//2.发送请求给阿里云
		CreateUploadVideo upload = aliyunVideoHelper.createUploadVideo(fileName, fileSize);
		//3.插入数据
		AliVideoUpload avu = new AliVideoUpload();
		avu.setCreateId(userId);
		avu.setCreateTime(DateUtil.current());
		avu.setDeleteFlag(false);
		avu.setRequestId(upload.getRequestId());
		avu.setStatus(AliVideoUpload.STATUS_UPLOADING);
		avu.setUploadAddress(upload.getUploadAddress());
		avu.setUploadAuth(upload.getUploadAuth());
		avu.setVideoId(upload.getVideoId());
		if (aliVideoUploadMapper.insertSelective(avu) != 1) {
			log.error("insert ali video upload error,videoId:{}, uploadAddress:{}, uploadAuth:{}", upload.getVideoId(), upload.getUploadAddress(), upload.getUploadAuth());
			throw new BusinessException("insert ali video upload error!");
		}
		//4.返回结果
		return upload;
	}
	/**
	 * 更新视频上传凭证（如果之前凭证失效）
	 * @param VideoId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public Object uploadVideoRefresh(String videoId, Long userId) throws Exception {
		/**
		 * 1.判断参数有效性 2.发送请求给阿里云 3.插入数据 4.返回结果
		 */
		//1.判断参数有效性
		if (StringUtils.isBlank(videoId) || userId <= 0) {
			return ResultUtil.PARAM_ERROR;
		}
		//2.发送请求给阿里云
		RefreshUploadVideo upload = aliyunVideoHelper.refreshUploadVideo(videoId);
		//3.插入数据
		AliVideoUpload avu = new AliVideoUpload();
		avu.setCreateId(userId);
		avu.setCreateTime(DateUtil.current());
		avu.setDeleteFlag(false);
		avu.setRequestId(upload.getRequestId());
		avu.setStatus(AliVideoUpload.STATUS_UPLOADING);
		avu.setUploadAuth(upload.getUploadAuth());
		avu.setVideoId(upload.getVideoId());
		if (aliVideoUploadMapper.insertSelective(avu) != 1) {
			log.error("refresh ali video upload error,videoId:{}, uploadAuth:{}", upload.getVideoId(), upload.getUploadAuth());
			throw new BusinessException("refresh ali video upload error!");
		}
		return upload;
	}
	
	/**
	 * 更新ali video视频信息
	 * @param param
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public Object videoInfoUpdate(UpdateVideoParam param, Long userId) throws Exception {
		/**
		 * 1.判断参数有效性 2、发送请求给阿里云 3、查询阿里云刚刚更新的数据 4、插入或者更新数据
		 */
		//1.判断参数有效性
		if (!ParamUtil.checkParamValid(param, null) || userId <= 0) {
			return ResultUtil.PARAM_ERROR;
		}
		//2.发送请求给阿里云
		UpdateVideoInfo info = aliyunVideoHelper.updateVideoInfo(param);
		log.warn("update ali video requestId:{}, videoId:{}", info.getRequestId(), param.getVideoId());
		//3.查询阿里云刚刚更新的数据
		GetVideoInfo videoInfo = aliyunVideoHelper.getVideoInfo(param.getVideoId());
		//4.插入或者更新数据
		AliVideo av = new AliVideo();
		copyAliVideoProps(av, videoInfo.getVideo());
		if (aliVideoMapper.existPrimaryKey(param.getVideoId())) {//更新
			if (aliVideoMapper.updateByPrimaryKeySelective(av) != 1) {
				log.error("update ali video info error, video id:{}", av.getVideoId());
				throw new BusinessException("update ali video info error!");
			}
		} else {//插入
			if (aliVideoMapper.insertSelective(av) != 1) {
				log.error("insert ali video info error, video id:{}", av.getVideoId());
				throw new BusinessException("insert ali video info error!");
			}
		}
		return aliVideoMapper.selectByPrimaryKey(av.getVideoId());
	}
	
	/**
	 * 	private String videoId;
		private String title;
		private String tags;
		private String status;
		private Long size;
		private Float duration;
		private String description;
		private String createTime;
		private String modifyTime;
		private String coverURL;
		private Integer cateId;
		private String cateName;
	 * @throws JsonProcessingException 
	 */
	private void copyAliVideoProps(AliVideo dest, com.aliyuncs.vod.model.v20170321.GetVideoInfoResponse.Video src) throws JsonProcessingException {
		dest.setCateId(src.getCateId());
		dest.setCateName(src.getCateName());
		dest.setCoverUrl(src.getCoverURL());
		if (StringUtils.isNotBlank(src.getCreateTime())) {
			dest.setCreateTime(parseCommonDate(src.getCreateTime()));
		}
		dest.setDeleteFlag(false);
		dest.setDescription(src.getDescription());
		dest.setDuration(src.getDuration() != null ? src.getDuration().intValue() : null);
		if (StringUtils.isNotBlank(src.getModifyTime())) {
			dest.setModifyTime(parseCommonDate(src.getModifyTime()));
		}
		dest.setSize(src.getSize());
		if (src.getSnapshots() != null) {
			dest.setSnapArray(src.getSnapshots().toArray(new String[]{}));
			dest.setSnapshots(objectMapper.writeValueAsString(src.getSnapshots()));
		}
	}
	
	/**
	 * 获取视频播放凭证
	 * @param videoId
	 * @return
	 * @throws Exception
	 */
	public Object videoPlayAuth(String videoId) throws Exception {
		if (StringUtils.isBlank(videoId)) {
			return ResultUtil.PARAM_ERROR;
		}
		return aliyunVideoHelper.getVideoPlayAuth(videoId);
	}
	
	public Object videoInfo(String videoId) throws Exception {
		if (StringUtils.isBlank(videoId)) {
			return ResultUtil.PARAM_ERROR;
		}
		return aliyunVideoHelper.getVideoInfo(videoId);
	}
	
	private Date parseCommonDate(String dateString) {
		try {
			return COMMON_DATE_FORMAT.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
