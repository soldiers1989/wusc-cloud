package com.cxc.course.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.auth.AuthRequired;
import com.cxc.auth.RoleType;
import com.cxc.course.model.Chapter;
import com.cxc.course.param.ChapterModifyParam;
import com.cxc.course.param.ChapterParam;
import com.cxc.course.service.ChapterService;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="Chapters", headers="Accept=application/json; version=1.0")
public class ChapterCtrl {
private static final Logger log = LoggerFactory.getLogger(ChapterCtrl.class);
	
	@Resource
	private ChapterService chapterService;
	
	@ApiOperation(value="根据{chapter_id}获取章", response=Chapter.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{chapter_id}", method=RequestMethod.GET)
	public Object chapter(@PathVariable("chapter_id") Long chapterId) {
		try {
			return chapterService.chapter(chapterId);
		} catch (Exception e) {
			log.error("ChapterCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据{chapter_id}删除章，接口仅开放给运营用户adminUser", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{chapter_id}", method=RequestMethod.DELETE)
	@AuthRequired(role=RoleType.manager)
	public Object chapterDelete(@PathVariable("chapter_id") Long chapterId) {
		try {
			return chapterService.chapterDelete(chapterId);
		} catch (Exception e) {
			log.error("ChapterCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增章，接口仅开放给运营用户adminUser", response=Chapter.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.POST)
	@AuthRequired(role=RoleType.manager)
	public Object chapterPost(@RequestBody ChapterParam body) {
		try {
			return chapterService.chapter(body);
		} catch (Exception e) {
			log.error("ChapterCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="修改章，接口仅开放给运营用户adminUser", response=Chapter.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{chapter_id}", method=RequestMethod.PUT)
	@AuthRequired(role=RoleType.manager)
	public Object chapterPut(@PathVariable("chapter_id") Long chapterId,  @RequestBody ChapterModifyParam body) {
		try {
			return chapterService.chapter(chapterId, body);
		} catch (Exception e) {
			log.error("ChapterCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
