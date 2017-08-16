package com.cxc.ms.service.mvc.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.cache.Cache;
import com.cxc.ms.service.mvc.model.Organization;
import com.cxc.ms.service.mvc.ret.Organizations;
import com.cxc.ms.service.mvc.service.OrganizationService;
import com.cxc.ms.service.mvc.vo.OrganizationParam;
import com.cxc.refresh.Refresh;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(headers="Accept=application/json; version=1.0", produces="application/json")
public class OrganizationCtrl {
	
	private static final Logger log = LoggerFactory.getLogger(OrganizationCtrl.class);
	
	@Resource
	private OrganizationService organizationService;
	
	@ApiOperation(value="获取机构全部数据", response=Organizations.class, notes="organizations-get")
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true)
	})
	@Cache(time=900000, type=Organizations.class)
	@RequestMapping(method=RequestMethod.GET, path="organizations")
	public Object organizations() {
		try {
			return organizationService.organizations();
		} catch (Exception e) {
			log.error("OrganizationCtrl get organizations error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增学校、组织", response=Organization.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true)
	})
	@Refresh()
	@RequestMapping(path="insertOrganization", method=RequestMethod.POST)
	public Object insertOrganization(@RequestBody OrganizationParam param){
		try {
			return organizationService.insertOrganization(param);
			
		} catch(Exception e){
			log.error("OrganizationCtrl insertOrganization", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据id获取学校、组织", response=Organization.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true)
	})
	@RequestMapping(path="getOrganizationById/{organizationId}", method=RequestMethod.GET)
	public Object getOrganizationById(@PathVariable(value="organizationId") Long organizationId){
		try {
			return organizationService.getOrganizationById(organizationId);
		} catch(Exception e){
			log.error("OrganizationCtrl getOrganizationById", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据名称获取所有的学校/组织", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true)
	})
	@Cache(time=900000, type=Object.class)
	@RequestMapping(value="getOrganizationByName",method=RequestMethod.GET)
	public Object getOrganizationByName(@RequestParam(value="name",required=false) String name, @RequestParam(value="offset",required=false) Integer offset){
		try{
			return organizationService.getByOrgName(name, offset);
		} catch(Exception e) {
			log.error("OrganizationCtrl getOrganizationByName", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据ID删除学校/组织", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true)
	})
	@Refresh()
	@RequestMapping(value="deleteOrganizationById/{organizationId}",method=RequestMethod.DELETE)
	public Object deleteOrganizationById(@PathVariable(value="organizationId") Long organizationId){
		try{
			return organizationService.deleteOrganizationById(organizationId);
		} catch(Exception e) {
			log.error("OrganizationCtrl deleteOrganizationById", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="编辑学校", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true)
	})
	@Refresh()
	@RequestMapping(value="editOrganization/{organizationId}",method=RequestMethod.PUT)
	public Object editOrganization(@PathVariable(value="organizationId",required=true)Long organizationId, @RequestBody OrganizationParam param){
		try {
			return organizationService.updateOrganizationById(organizationId, param);
		} catch(Exception e) {
			log.error("OrganizationCtrl editOrganization",e );
		}
		return ResultUtil.SYSTEM_ERROR;
	}

}
