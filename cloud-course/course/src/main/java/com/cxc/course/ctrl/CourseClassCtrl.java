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
import com.cxc.course.model.CourseClass;
import com.cxc.course.param.CourseClassModifyParam;
import com.cxc.course.param.CourseClassParam;
import com.cxc.course.service.CourseClassService;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="courseClasses", headers="Accept=application/json; version=1.0")
public class CourseClassCtrl {
private static final Logger log = LoggerFactory.getLogger(CourseClassCtrl.class);
	
	@Resource
	private CourseClassService courseClassService;
	
	@ApiOperation(value="根据{class_id}获取课程大类", response=CourseClass.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{class_id}", method=RequestMethod.GET)
	public Object courseClass(@PathVariable("class_id") Integer classId) {
		try {
			return courseClassService.courseClass(classId);
		} catch (Exception e) {
			log.error("CourseClassCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据{class_id}删除课程大类，接口仅开放给运营用户adminUser", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{class_id}", method=RequestMethod.DELETE)
	@AuthRequired(role=RoleType.manager)
	public Object courseClassDelete(@PathVariable("class_id") Integer classId) {
		try {
			return courseClassService.courseClassDelete(classId);
		} catch (Exception e) {
			log.error("CourseClassCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增课程大类，接口仅开放给运营用户adminUser", response=CourseClass.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.POST)
	@AuthRequired(role=RoleType.manager)
	public Object courseClassPost(@RequestBody CourseClassParam body) {
		try {
			return courseClassService.courseClass(body);
		} catch (Exception e) {
			log.error("CourseClassCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="修改课程大类，接口仅开放给运营用户adminUser", response=CourseClass.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{class_id}", method=RequestMethod.PUT)
	@AuthRequired(role=RoleType.manager)
	public Object courseClassPut(@PathVariable("class_id") Integer classId,  @RequestBody CourseClassModifyParam body) {
		try {
			return courseClassService.courseClass(classId, body);
		} catch (Exception e) {
			log.error("CourseClassCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	
	@ApiOperation(value="获取所有的课程类型，树形结构", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="courseClassContent", method=RequestMethod.GET)
	public Object getCourseClassContent(){
		try {
			return courseClassService.getCourseClassContent();
		} catch (Exception e) {
			log.error("CourseClassCtrl getCourseClassContent", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
}
