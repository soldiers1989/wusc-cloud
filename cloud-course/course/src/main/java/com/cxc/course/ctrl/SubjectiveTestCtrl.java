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

import com.cxc.auth.AuthRequired;
import com.cxc.auth.RoleType;
import com.cxc.course.model.SubjectiveTest;
import com.cxc.course.param.SubjectiveTestModifyParam;
import com.cxc.course.param.SubjectiveTestParam;
import com.cxc.course.service.SubjectiveTestService;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value="subjectiveTests", headers="Accept=application/json; version=1.0")
public class SubjectiveTestCtrl {

private static final Logger log = LoggerFactory.getLogger(SubjectiveTestCtrl.class);
	
	@Resource
	private SubjectiveTestService subjectiveTestService;
	
	@ApiOperation(value="根据{question_id}获取客观题", response=SubjectiveTest.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{question_id}", method=RequestMethod.GET)
	public Object subjectiveTests(@PathVariable("question_id") Long questionId) {
		try {
			return subjectiveTestService.subjectiveTest(questionId);
		} catch (Exception e) {
			log.error("SubjectiveTestCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}

	
	@ApiOperation(value="根据{question_id}删除客观题，接口仅开放给运营用户adminUser", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{question_id}", method=RequestMethod.DELETE)
	@AuthRequired(role=RoleType.manager)
	public Object subjectiveTestsDelete(@PathVariable("question_id") Long questionId) {
		try {
			return subjectiveTestService.subjectiveTestDelete(questionId);
		} catch (Exception e) {
			log.error("SubjectiveTestCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增客观题，接口仅开放给运营用户adminUser", response=SubjectiveTest.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.POST)
	@AuthRequired(role=RoleType.manager)
	public Object subjectiveTestsPost(@RequestBody SubjectiveTestParam body, @ApiIgnore @RequestHeader("admin_user_id") Long userId) {
		try {
			return subjectiveTestService.subjectiveTest(body, userId);
		} catch (Exception e) {
			log.error("SubjectiveTestCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="修改客观题，接口仅开放给运营用户adminUser", response=SubjectiveTest.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{question_id}", method=RequestMethod.PUT)
	@AuthRequired(role=RoleType.manager)
	public Object subjectiveTestsPut(@PathVariable("question_id") Long questionId,  @RequestBody SubjectiveTestModifyParam body, @ApiIgnore @RequestHeader("admin_user_id") Long userId) {
		try {
			return subjectiveTestService.subjectiveTest(questionId, body, userId);
		} catch (Exception e) {
			log.error("SubjectiveTestCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
