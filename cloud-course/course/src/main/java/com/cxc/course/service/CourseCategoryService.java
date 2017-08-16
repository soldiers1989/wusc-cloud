package com.cxc.course.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.course.model.CourseCategoryExample;
import com.cxc.course.mapper.CourseCategoryMapper;
import com.cxc.course.model.CourseCategory;
import com.cxc.course.param.CourseCategoryModifyParam;
import com.cxc.course.param.CourseCategoryParam;
import com.cxc.util.DateUtil;
import com.cxc.util.ParamUtil;
import com.cxc.util.PropertyUtil;
import com.cxc.util.ResultUtil;

@Service

public class CourseCategoryService {

	@Resource
	private CourseCategoryMapper courseCategoryMapper;
	
	public Object courseCategory(Integer categoryId) throws Exception {
		CourseCategory courseCategory = courseCategoryMapper.selectByPrimaryKey(categoryId);
		if (courseCategory != null) return courseCategory;
		return ResultUtil.NO_DATA_ERROR;
	}
	
	public Object courseCategoryDelete(Integer categoryId) throws Exception {
		if (courseCategoryMapper.deleteByPrimaryKey(categoryId) == 1) {
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public List<CourseCategory> selectCourseCategoryList(CourseCategoryExample courseCategoryExample) throws Exception {
		
		return courseCategoryMapper.selectByExample(courseCategoryExample);
    }
	
	public Object courseCategory(CourseCategoryParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		CourseCategory courseCategory = new CourseCategory();
		PropertyUtil.copy(param, courseCategory);
		
		if (courseCategory.getDepict() == null) {
			courseCategory.setDepict("");
		}
		if (courseCategory.getPictureUrl() == null) {
			courseCategory.setPictureUrl("");
		}
		courseCategory.setSn(DateUtil.current());
		
		if (courseCategoryMapper.insertSelective(courseCategory) == 1) {
			return courseCategoryMapper.selectByPrimaryKey(courseCategory.getCategoryId());
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object courseCategory(Integer categoryId, CourseCategoryModifyParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null) || categoryId <= 0) {
			return ResultUtil.PARAM_ERROR;
		}
		CourseCategory courseCategory = new CourseCategory();
		PropertyUtil.copy(param, courseCategory);
		courseCategory.setCategoryId(categoryId);
		
		if (courseCategoryMapper.updateByPrimaryKeySelective(courseCategory) == 1) {
			return courseCategoryMapper.selectByPrimaryKey(categoryId);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
