package com.cxc.course.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.cache.Cache;
import com.cxc.course.model.CourseCategoryExample;
import com.cxc.course.model.CourseExample;
import com.cxc.course.service.CourseCategoryService;
import com.cxc.course.service.CourseService;
import com.cxc.util.ResultUtil;
import com.cxc.vo.MainPageData;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="homePageServices", headers="Accept=application/json; version=1.0")
public class HomePageServices {
	private static final Logger log = LoggerFactory.getLogger(HomePageServices.class);

	@Resource
	private CourseCategoryService courseCategoryService;

	@Resource
	private CourseService courseService;
	
	@ApiOperation(value="获取书院首页数据", response=MainPageData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.GET)
	@Cache(time=600000, type=MainPageData.class)
	public Object getHomePageServices() {
			
		CourseExample recommendedCourseExample=new CourseExample();
		CourseExample.Criteria criteria1 = recommendedCourseExample.createCriteria(); 
		criteria1.andRecommendedLevelEqualTo((short) 2);
		CourseExample.Criteria orCriteria1 = recommendedCourseExample.createCriteria(); 
		orCriteria1.andRecommendedLevelEqualTo((short) 12);
		recommendedCourseExample.or(orCriteria1);
		recommendedCourseExample.setOrderByClause("sn asc");
		
		CourseCategoryExample courseCategoryExample=new CourseCategoryExample();
		CourseCategoryExample.Criteria courseCategoryCriteria = courseCategoryExample.createCriteria(); 
		courseCategoryCriteria.andCategoryIdNotEqualTo(-1);
		courseCategoryExample.setOrderByClause("sn asc");
		
		
		CourseExample specialCourseExample=new CourseExample();
		CourseExample.Criteria criteria2 = specialCourseExample.createCriteria(); 
		criteria2.andRecommendedLevelEqualTo((short) 1);
		CourseExample.Criteria orCriteria2 = specialCourseExample.createCriteria(); 
		orCriteria2.andRecommendedLevelEqualTo((short) 12);
		specialCourseExample.or(orCriteria2);
		specialCourseExample.setOrderByClause("sn asc");
		

		MainPageData mainPageData=new MainPageData();
		try {
			mainPageData.setSpecialCourse(courseService.selectCourses(specialCourseExample));
			mainPageData.setCourseCategory(courseCategoryService.selectCourseCategoryList(courseCategoryExample));
			mainPageData.setRecommendCourse(courseService.selectCourses(recommendedCourseExample));
			return mainPageData;
		} catch (Exception e) {
			log.error("CourseCategoryCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
