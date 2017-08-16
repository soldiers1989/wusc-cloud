package com.cxc.course.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.course.mapper.CourseCommentMapper;
import com.cxc.course.model.CourseComment;
import com.cxc.course.model.CourseCommentExample;
import com.cxc.course.model.User;
import com.cxc.course.param.CourseCommentModifyParam;
import com.cxc.course.param.CourseCommentParam;
import com.cxc.util.DateUtil;
import com.cxc.util.ParamUtil;
import com.cxc.util.PropertyUtil;
import com.cxc.util.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class CourseCommentService {
	@Resource
	private CourseCommentMapper courseCommentMapper;
	@Resource
	private UserAccessService userAccessService;
	
	public Object courseComment(Long commentId) throws Exception {
		CourseComment courseComment = courseCommentMapper.selectByPrimaryKey(commentId);
		if (courseComment != null) return courseComment;
		return ResultUtil.NO_DATA_ERROR;
	}
	
	public List<CourseComment> selectCourseComments(CourseCommentExample courseCommentExample, Integer offset) throws Exception {
		if (offset == null) offset = 0;
		Page<CourseComment> page = PageHelper.offsetPage(offset, 20);
		courseCommentMapper.selectByExample(courseCommentExample);
        return page.toPageInfo().getList();
    }
	
	public List<CourseComment> selectCourseComments(CourseCommentExample courseCommentExample) throws Exception {
        return courseCommentMapper.selectByExample(courseCommentExample);
    }
	
	public int countCourseComments(CourseCommentExample courseCommentExample) throws Exception {
        return courseCommentMapper.countByExample(courseCommentExample);
    }
	
	public Object courseCommentDelete(Long commentId) throws Exception {
		if (courseCommentMapper.deleteByPrimaryKey(commentId) == 1) {
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object courseComment(CourseCommentParam param, Long userId) throws Exception {
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		User user=userAccessService.getUserInfo(userId);
		CourseComment courseComment = new CourseComment();
		PropertyUtil.copy(param, courseComment);
		
		if (courseComment.getPictureUrl() == null) {
			courseComment.setPictureUrl("");
		}		
		if (courseComment.getUnderwrite() == null) {
			courseComment.setUnderwrite("");
		}
		if (user.getUserName() != null) {
			courseComment.setNickname(user.getUserName());
		}
		if (user.getPhotoUrl() != null) {
			courseComment.setPhotoUrl(user.getPhotoUrl());
		}
		courseComment.setCreated(DateUtil.current());
		courseComment.setUserId(userId);
		
		if (courseCommentMapper.insertSelective(courseComment) == 1) {
			return courseCommentMapper.selectByPrimaryKey(courseComment.getCommentId());
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object courseComment(Long commentId, CourseCommentModifyParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null) || commentId <= 0) {
			return ResultUtil.PARAM_ERROR;
		}
		CourseComment courseComment = new CourseComment();
		PropertyUtil.copy(param, courseComment);
		courseComment.setCommentId(commentId);
		courseComment.setUpdated(DateUtil.current());
		
		if (courseCommentMapper.updateByPrimaryKeySelective(courseComment) == 1) {
			return courseCommentMapper.selectByPrimaryKey(commentId);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
