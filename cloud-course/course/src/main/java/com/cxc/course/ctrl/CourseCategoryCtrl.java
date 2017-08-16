package com.cxc.course.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.course.model.CourseCategoryExample;
import com.cxc.course.model.CourseExample;
import com.cxc.auth.AuthRequired;
import com.cxc.auth.RoleType;
import com.cxc.course.model.CourseCategory;
import com.cxc.course.param.CourseCategoryModifyParam;
import com.cxc.course.param.CourseCategoryParam;
import com.cxc.course.service.CourseCategoryService;
import com.cxc.course.service.CourseService;
import com.cxc.util.ResultUtil;
import com.cxc.vo.CourseCategoryListData;
import com.cxc.vo.CourseListData;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="courseCategories", headers="Accept=application/json; version=1.0")
public class CourseCategoryCtrl {
private static final Logger log = LoggerFactory.getLogger(CourseCategoryCtrl.class);

	@Resource
	private CourseCategoryService courseCategoryService;

	@Resource
	private CourseService courseService;
	
	@ApiOperation(value="根据{courseCategory_id}获取课程分类", response=CourseCategory.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{courseCategory_id}", method=RequestMethod.GET)
	public Object courseCategory(@PathVariable("courseCategory_id") Integer categoryId) {
		try {
			return courseCategoryService.courseCategory(categoryId);
		} catch (Exception e) {
			log.error("CourseCategoryCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="获取属于{category_id}分类的所有课程，有排序（按timestamp）", response=CourseListData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{category_id}/courses", method=RequestMethod.GET)
	public Object getCursesByCategoryId(@PathVariable("category_id") Integer categoryId, @RequestParam(value="offset", required=false) Integer offset) {
				
		CourseExample courseExample=new CourseExample();
		CourseExample.Criteria criteria = courseExample.createCriteria(); 
		criteria.andCategoryIdEqualTo(categoryId);
		courseExample.setOrderByClause("sn desc");
		
		try {
			return new CourseListData(courseService.selectCourses(courseExample, offset));
		} catch (Exception e) {
			log.error("CourseCategoryCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="获取所有的课程分类，有排序（按timestamp）", response=CourseCategoryListData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.GET)
	public Object getCursesByCategoryId() {
				
		CourseCategoryExample courseCategoryExample=new CourseCategoryExample();
		CourseCategoryExample.Criteria criteria = courseCategoryExample.createCriteria(); 
		criteria.andCategoryIdNotEqualTo(-1);
		courseCategoryExample.setOrderByClause("sn desc");
		
		try {
			return new CourseCategoryListData(courseCategoryService.selectCourseCategoryList(courseCategoryExample));
		} catch (Exception e) {
			log.error("CourseCategoryCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据{courseCategory_id}删除课程分类，接口仅开放给运营用户adminUser", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{courseCategory_id}", method=RequestMethod.DELETE)
	@AuthRequired(role=RoleType.manager)
	public Object courseCategoryDelete(@PathVariable("courseCategory_id") Integer categoryId) {
		try {
			return courseCategoryService.courseCategoryDelete(categoryId);
		} catch (Exception e) {
			log.error("CourseCategoryCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增课程分类，接口仅开放给运营用户adminUser", response=CourseCategory.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.POST)
	@AuthRequired(role=RoleType.manager)
	public Object courseCategoryPost(@RequestBody CourseCategoryParam body) {
		try {
			return courseCategoryService.courseCategory(body);
		} catch (Exception e) {
			log.error("CourseCategoryCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="修改课程分类，接口仅开放给运营用户adminUser", response=CourseCategory.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{courseCategory_id}", method=RequestMethod.PUT)
	@AuthRequired(role=RoleType.manager)
	public Object courseCategoryPut(@PathVariable("courseCategory_id") Integer categoryId,  @RequestBody CourseCategoryModifyParam body) {
		try {
			return courseCategoryService.courseCategory(categoryId, body);
		} catch (Exception e) {
			log.error("CourseCategoryCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
