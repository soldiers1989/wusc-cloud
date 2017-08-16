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
import com.cxc.course.model.ObjectiveTest;
import com.cxc.course.param.ObjectiveTestModifyParam;
import com.cxc.course.param.ObjectiveTestParam;
import com.cxc.course.service.ObjectiveTestService;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value="objectiveTests", headers="Accept=application/json; version=1.0")
public class ObjectiveTestCtrl {

private static final Logger log = LoggerFactory.getLogger(ObjectiveTestCtrl.class);
	
	@Resource
	private ObjectiveTestService objectiveTestService;
	
	@ApiOperation(value="根据{question_id}获取主观题", response=ObjectiveTest.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{question_id}", method=RequestMethod.GET)
	public Object objectiveTests(@PathVariable("question_id") Long questionId) {
		try {
			return objectiveTestService.objectiveTest(questionId);
		} catch (Exception e) {
			log.error("ObjectiveTestCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}

	@ApiOperation(value="根据{question_id}删除主观题，接口仅开放给运营用户adminUser", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{question_id}", method=RequestMethod.DELETE)
	@AuthRequired(role=RoleType.manager)
	public Object objectiveTestsDelete(@PathVariable("question_id") Long questionId) {
		try {
			return objectiveTestService.objectiveTestDelete(questionId);
		} catch (Exception e) {
			log.error("ObjectiveTestCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增主观题，接口仅开放给运营用户adminUser", response=ObjectiveTest.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.POST)
	@AuthRequired(role=RoleType.manager)
	public Object objectiveTestsPost(@RequestBody ObjectiveTestParam body, @ApiIgnore @RequestHeader("admin_user_id") Long userId) {
		try {
			return objectiveTestService.objectiveTest(body, userId);
		} catch (Exception e) {
			log.error("ObjectiveTestCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="修改主观题，接口仅开放给运营用户adminUser", response=ObjectiveTest.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{question_id}", method=RequestMethod.PUT)
	@AuthRequired(role=RoleType.manager)
	public Object objectiveTestsPut(@PathVariable("question_id") Long questionId,  @RequestBody ObjectiveTestModifyParam body, @ApiIgnore @RequestHeader("admin_user_id") Long userId) {
		try {
			return objectiveTestService.objectiveTest(questionId, body, userId);
		} catch (Exception e) {
			log.error("ObjectiveTestCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
