package com.cxc.video.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.auth.AuthRequired;
import com.cxc.auth.RoleType;
import com.cxc.cache.Cache;
import com.cxc.refresh.Refresh;
import com.cxc.util.ResultUtil;
import com.cxc.video.ali.CreateUploadVideo;
import com.cxc.video.ali.GetVideoInfo;
import com.cxc.video.ali.GetVideoPlayAuth;
import com.cxc.video.ali.RefreshUploadVideo;
import com.cxc.video.model.AliVideo;
import com.cxc.video.param.ResourceParam;
import com.cxc.video.param.UpdateVideoParam;
import com.cxc.video.param.VideoUploadAuthParam;
import com.cxc.video.ret.OssSign;
import com.cxc.video.ret.OssSignApp;
import com.cxc.video.service.OssService;
import com.cxc.video.service.ResourceService;
import com.cxc.video.service.VideoService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 资源控制器
 * @author wanglei
 * 2017-5-2
 */
@RestController
@RequestMapping(headers="Accept=application/json; version=1.0")
public class ResourceCtrl {
	private static final Logger log = LoggerFactory.getLogger(ResourceCtrl.class);
	
	@Resource
	private OssService ossService;
	@Resource
	private VideoService videoService;
	@Resource
	private ResourceService resourceService;
	
	@ApiOperation(value="获取文件上传凭证,web端用（不是视频）", response = OssSign.class, tags="resources-oss-sign-get")
	@ApiImplicitParams({
		@ApiImplicitParam(value="用户编号", name="admin_user_id", dataType="java.lang.String", paramType="header", required=true),
		@ApiImplicitParam(value="令牌", name="admin_token", dataType="java.lang.String", paramType="header", required=true)
	})
	@RequestMapping(value="/resources/oss/sign", method=RequestMethod.GET)
	@AuthRequired(role=RoleType.manager)
	@Cache(type=OssSign.class, time=600000)
	public Object ossSign(HttpServletRequest request, HttpServletResponse response) {
		try {
			return ossService.policy(request, response);
		} catch (Exception e) {
			log.error("ResourceCtrl ossSign error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="获取文件上传凭证,app用（不是视频）", response = OssSignApp.class, tags="resources-oss-sign-app-get")
	@ApiImplicitParams({
		@ApiImplicitParam(value="用户编号", name="user_id", dataType="java.lang.String", paramType="header", required=true),
		@ApiImplicitParam(value="令牌", name="token", dataType="java.lang.String", paramType="header", required=true)
	})
	@RequestMapping(value="/resources/oss/sign/app", method=RequestMethod.GET)
	public Object ossSign(@RequestHeader("user_id") Long userId) {
		try {
			return ossService.policyApp(userId);
		} catch (Exception e) {
			log.error("ResourceCtrl ossSign app error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="获取视频播放凭证", response = GetVideoPlayAuth.class, tags="resources-video-auth-get")
	@ApiImplicitParams({
		@ApiImplicitParam(value="用户编号", name="user_id", dataType="java.lang.String", paramType="header", required=true),
		@ApiImplicitParam(value="令牌", name="token", dataType="java.lang.String", paramType="header", required=true)
	})
	@RequestMapping(value="/resources/video/{video_id}/auth", method=RequestMethod.GET)
	public Object videoPlayAuth(@PathVariable("video_id") String videoId) {
		try {
			return videoService.videoPlayAuth(videoId);
		} catch (Exception e) {
			log.error("ResourceCtrl videoPlayAuth error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="获取视频信息", response = GetVideoInfo.class, tags="resources-video-get")
	@ApiImplicitParams({
		@ApiImplicitParam(value="用户编号", name="user_id", dataType="java.lang.String", paramType="header", required=true),
		@ApiImplicitParam(value="令牌", name="token", dataType="java.lang.String", paramType="header", required=true)
	})
	@Cache(time=600000, type=GetVideoInfo.class)
	@RequestMapping(value="/resources/video/{video_id}", method=RequestMethod.GET)
	public Object videoInfo(@PathVariable("video_id") String videoId) {
		try {
			return videoService.videoInfo(videoId);
		} catch (Exception e) {
			log.error("ResourceCtrl video info error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	
	@ApiOperation(value="更新视频信息", response = AliVideo.class, tags="resources-video-put")
	@ApiImplicitParams({
		@ApiImplicitParam(value="用户编号", name="user_id", dataType="java.lang.String", paramType="header", required=true),
		@ApiImplicitParam(value="令牌", name="token", dataType="java.lang.String", paramType="header", required=true)
	})
	@RequestMapping(value="/resources/video", method=RequestMethod.PUT)
	public Object video(@RequestBody UpdateVideoParam param, @RequestHeader("admin_user_id") Long userId) {
		try {
			return videoService.videoInfoUpdate(param, userId);
		} catch (Exception e) {
			log.error("ResourceCtrl video info update error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="获取视频上传凭证", response = CreateUploadVideo.class)
	@ApiImplicitParams({
		@ApiImplicitParam(value="用户编号", name="admin_user_id", dataType="java.lang.String", paramType="header", required=true),
		@ApiImplicitParam(value="令牌", name="admin_token", dataType="java.lang.String", paramType="header", required=true)
	})
	@AuthRequired(role = RoleType.manager)
	@RequestMapping(value="/resources/videoUploadAuth", method=RequestMethod.POST)
	public Object videoUploadAuth(@RequestBody VideoUploadAuthParam param, @RequestHeader("admin_user_id") Long userId) {
		try {
			return videoService.uploadVideoCreate(param.getFileName(), param.getFileSize(), userId);
		} catch (Exception e) {
			log.error("ResourceCtrl videoUploadAuth error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="更新{videoId}视频上传凭证", response = RefreshUploadVideo.class)
	@ApiImplicitParams({
		@ApiImplicitParam(value="用户编号", name="admin_user_id", dataType="java.lang.String", paramType="header", required=true),
		@ApiImplicitParam(value="令牌", name="admin_token", dataType="java.lang.String", paramType="header", required=true)
	})
	@RequestMapping(value="/resources/videoUploadAuth/{video_id}", method=RequestMethod.POST)
	@AuthRequired(role = RoleType.manager)
	public Object videoUploadAuth(@RequestHeader("admin_user_id")  Long userId, @PathVariable("video_id") String videoId) {
		try {
			return videoService.uploadVideoRefresh(videoId, userId);
		} catch (Exception e) {
			log.error("ResourceCtrl videoUploadAuth refresh error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="获取资源信息", response = GetVideoInfo.class, tags="resource-id-get")
	@ApiImplicitParams({
		@ApiImplicitParam(value="用户编号", name="user_id", dataType="java.lang.String", paramType="header", required=true),
		@ApiImplicitParam(value="令牌", name="token", dataType="java.lang.String", paramType="header", required=true)
	})
	@Cache(time=600000, type=Resource.class)
	@RequestMapping(value="/resources/{resource_id}", method=RequestMethod.GET)
	public Object resource(@PathVariable("resource_id") Long resourceId, @RequestHeader("user_id") Long userId) {
		try {
			return resourceService.resource(resourceId, userId);
		} catch (Exception e) {
			log.error("ResourceCtrl resource info error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增一条资源", response=ResourceParam.class)
	@ApiImplicitParams({
		@ApiImplicitParam(value="用户编号", name="user_id", dataType="java.lang.String", paramType="header", required=true),
		@ApiImplicitParam(value="令牌", name="token", dataType="java.lang.String", paramType="header", required=true)
	})
	@Refresh()
	@RequestMapping(value="insertResource", method=RequestMethod.POST)
	public Object insertResource(@RequestBody ResourceParam param){
		try {
			return resourceService.insertResource(param);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			log.error("ResourceCtrl insertResource error!", e);
		}	
		return ResultUtil.SYSTEM_ERROR;
	}
}
