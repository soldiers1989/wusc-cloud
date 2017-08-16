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
import com.cxc.course.model.Section;
import com.cxc.course.param.SectionModifyParam;
import com.cxc.course.param.SectionParam;
import com.cxc.course.service.SectionService;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="sections", headers="Accept=application/json; version=1.0")
public class SectionCtrl {
private static final Logger log = LoggerFactory.getLogger(SectionCtrl.class);
	
	@Resource
	private SectionService sectionService;
	
	@ApiOperation(value="根据{section_id}获取节", response=Section.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{section_id}", method=RequestMethod.GET)
	public Object section(@PathVariable("section_id") Long sectionId) {
		try {
			return sectionService.section(sectionId);
		} catch (Exception e) {
			log.error("SectionCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据{section_id}删除节，接口仅开放给运营用户adminUser", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{section_id}", method=RequestMethod.DELETE)
	@AuthRequired(role=RoleType.manager)
	public Object sectionDelete(@PathVariable("section_id") Long sectionId) {
		try {
			return sectionService.sectionDelete(sectionId);
		} catch (Exception e) {
			log.error("SectionCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增节，接口仅开放给运营用户adminUser", response=Section.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.POST)
	@AuthRequired(role=RoleType.manager)
	public Object sectionPost(@RequestBody SectionParam body) {
		try {
			return sectionService.section(body);
		} catch (Exception e) {
			log.error("SectionCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="修改节，接口仅开放给运营用户adminUser", response=Section.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{section_id}", method=RequestMethod.PUT)
	@AuthRequired(role=RoleType.manager)
	public Object sectionPut(@PathVariable("section_id") Long sectionId,  @RequestBody SectionModifyParam body) {
		try {
			return sectionService.section(sectionId, body);
		} catch (Exception e) {
			log.error("SectionCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
