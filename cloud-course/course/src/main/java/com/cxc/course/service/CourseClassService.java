package com.cxc.course.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxc.course.mapper.CourseCategoryMapper;
import com.cxc.course.mapper.CourseClassMapper;
import com.cxc.course.model.CourseCategory;
import com.cxc.course.model.CourseCategoryExample;
import com.cxc.course.model.CourseCategoryExample.Criteria;
import com.cxc.course.model.CourseClass;
import com.cxc.course.param.CourseClassModifyParam;
import com.cxc.course.param.CourseClassParam;
import com.cxc.course.ret.ClassContentRet;
import com.cxc.util.DateUtil;
import com.cxc.util.ParamUtil;
import com.cxc.util.PropertyUtil;
import com.cxc.util.ResultUtil;

@Service
public class CourseClassService {
	@Resource
	private CourseClassMapper courseClassMapper;
	
	@Resource
	private CourseCategoryMapper courseCategoryMapper;
	
	public Object courseClass(Integer classId) throws Exception {
		CourseClass courseClass = courseClassMapper.selectByPrimaryKey(classId);
		if (courseClass != null) return courseClass;
		return ResultUtil.NO_DATA_ERROR;
	}
	
	public Object courseClassDelete(Integer classId) throws Exception {
		if (courseClassMapper.deleteByPrimaryKey(classId) == 1) {
			//同步删除课程子类
			CourseCategoryExample courseCategoryExample=new CourseCategoryExample();
			Criteria criteria = courseCategoryExample.createCriteria(); 
			criteria.andClassIdEqualTo(classId);
			if(courseCategoryMapper.deleteByExample(courseCategoryExample) == 1){
				return ResultUtil.EMPTY_RESULT;
			}
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object courseClass(CourseClassParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		CourseClass courseClass = new CourseClass();
		PropertyUtil.copy(param, courseClass);
		
		if (courseClass.getDepict() == null) {
			courseClass.setDepict("");
		}
		if (courseClass.getPictureUrl() == null) {
			courseClass.setPictureUrl("");
		}
		courseClass.setSn(DateUtil.current());
		
		if (courseClassMapper.insertSelective(courseClass) == 1) {
			return courseClassMapper.selectByPrimaryKey(courseClass.getClassId());
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	public Object courseClass(Integer classId, CourseClassModifyParam param) throws Exception {
		if (!ParamUtil.checkParamValid(param, null) || classId <= 0) {
			return ResultUtil.PARAM_ERROR;
		}
		CourseClass courseClass = new CourseClass();
		PropertyUtil.copy(param, courseClass);
		courseClass.setClassId(classId);
		
		if (courseClassMapper.updateByPrimaryKeySelective(courseClass) == 1) {
			return courseClassMapper.selectByPrimaryKey(classId);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	
	/**
	 * 获取所有的课程类型，按树形展示
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public List<ClassContentRet> getCourseClassContent() throws Exception {
		List<CourseClass> lstClass = courseClassMapper.selectByExample(null);
		List<CourseCategory> lstCategory = courseCategoryMapper.selectByExample(null);
		List<ClassContentRet> lstClassRet = new ArrayList<ClassContentRet>();
		if(!lstClass.isEmpty()){
			lstClassRet = lstClass.stream().map(t->{
				ClassContentRet ret = new ClassContentRet();
				PropertyUtil.copy(t, ret);
				return ret;
			}).collect(Collectors.toList());
		}
		
		if(!lstCategory.isEmpty()){
			Map<Integer, List<Object>> classToCategoryMap = new HashMap<>();
			lstCategory.stream().forEach(t->{
				List<Object> list = classToCategoryMap.getOrDefault(t.getClassId(), new ArrayList<Object>());
				list.add(t);
				classToCategoryMap.put(t.getClassId(), list);
			});
			lstClassRet.forEach(t->{
				if(classToCategoryMap.containsKey(t.getClassId())){
					t.setChildren(classToCategoryMap.get(t.getClassId()));
				}
			});
		}
		return lstClassRet;
	}

}
