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
import com.cxc.course.model.Unit;
import com.cxc.course.param.UnitModifyParam;
import com.cxc.course.param.UnitParam;
import com.cxc.course.service.UnitService;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="units", headers="Accept=application/json; version=1.0")
public class UnitCtrl {
private static final Logger log = LoggerFactory.getLogger(UnitCtrl.class);
	
	@Resource
	private UnitService unitService;
	
	@ApiOperation(value="根据{unit_id}获取单元", response=Unit.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{unit_id}", method=RequestMethod.GET)
	public Object units(@PathVariable("unit_id") Long unitId) {
		try {
			return unitService.unit(unitId);
		} catch (Exception e) {
			log.error("UnitCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据{unit_id}删除单元，接口仅开放给运营用户adminUser", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{unit_id}", method=RequestMethod.DELETE)
	@AuthRequired(role=RoleType.manager)
	public Object unitsDelete(@PathVariable("unit_id") Long unitId) {
		try {
			return unitService.unitDelete(unitId);
		} catch (Exception e) {
			log.error("UnitCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增单元，接口仅开放给运营用户adminUser", response=Unit.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.POST)
	@AuthRequired(role=RoleType.manager)
	public Object unitsPost(@RequestBody UnitParam body) {
		try {
			return unitService.unit(body);
		} catch (Exception e) {
			log.error("UnitCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="修改单元，接口仅开放给运营用户adminUser", response=Unit.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{unit_id}", method=RequestMethod.PUT)
	@AuthRequired(role=RoleType.manager)
	public Object unitsPut(@PathVariable("unit_id") Long unitId,  @RequestBody UnitModifyParam body) {
		try {
			return unitService.unit(unitId, body);
		} catch (Exception e) {
			log.error("UnitCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
