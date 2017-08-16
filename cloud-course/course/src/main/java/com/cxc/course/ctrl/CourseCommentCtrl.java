package com.cxc.course.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.course.model.CourseComment;
import com.cxc.course.param.CourseCommentModifyParam;
import com.cxc.course.param.CourseCommentParam;
import com.cxc.course.service.CourseCommentService;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value="courseComments", headers="Accept=application/json; version=1.0")
public class CourseCommentCtrl {

private static final Logger log = LoggerFactory.getLogger(CourseCommentCtrl.class);
	
	@Resource
	private CourseCommentService courseCommentService;
	
	@ApiOperation(value="根据{comment_id}获取课程评论", response=CourseComment.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{comment_id}", method=RequestMethod.GET)
	public Object courseComments(@PathVariable("comment_id") Long commentId) {
		try {
			return courseCommentService.courseComment(commentId);
		} catch (Exception e) {
			log.error("CourseCommentCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据{comment_id}删除课程评论", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{comment_id}", method=RequestMethod.DELETE)
	public Object courseCommentsDelete(@PathVariable("comment_id") Long commentId) {
		try {
			return courseCommentService.courseCommentDelete(commentId);
		} catch (Exception e) {
			log.error("CourseCommentCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增课程评论", response=CourseComment.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.POST)
	public Object courseCommentsPost(@RequestBody CourseCommentParam body, @ApiIgnore @RequestHeader("user_id") Long userId) {
		try {
			return courseCommentService.courseComment(body, userId);
		} catch (Exception e) {
			log.error("CourseCommentCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="修改课程评论", response=CourseComment.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{comment_id}", method=RequestMethod.PUT)
	public Object courseCommentsPut(@PathVariable("comment_id") Long commentId,  @RequestBody CourseCommentModifyParam body) {
		try {
			return courseCommentService.courseComment(commentId, body);
		} catch (Exception e) {
			log.error("CourseCommentCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
