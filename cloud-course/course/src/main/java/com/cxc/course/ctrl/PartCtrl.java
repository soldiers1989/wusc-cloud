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
import com.cxc.course.model.ObjectiveTestExample;
import com.cxc.course.model.Part;
import com.cxc.course.param.PartModifyParam;
import com.cxc.course.param.PartParam;
import com.cxc.course.service.ObjectiveTestService;
import com.cxc.course.service.PartService;
import com.cxc.util.ResultUtil;
import com.cxc.vo.ObjectiveTestListData;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value="parts", headers="Accept=application/json; version=1.0")
public class PartCtrl {
private static final Logger log = LoggerFactory.getLogger(PartCtrl.class);
	
	@Resource
	private PartService partService;
	@Resource
	private ObjectiveTestService objectiveTestService;
	
	@ApiOperation(value="根据{part_id}获取部分", response=Part.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{part_id}", method=RequestMethod.GET)
	public Object parts(@PathVariable("part_id") Long partId) {
		try {
			return partService.part(partId);
		} catch (Exception e) {
			log.error("PartCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据{part_id}获取客观题", response=ObjectiveTestListData.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{part_id}/objectiveTests", method=RequestMethod.GET)
	public Object getObjectiveTestsOfPart(@PathVariable("part_id") Long partId) {
		
		ObjectiveTestExample objectiveTestExample=new ObjectiveTestExample();
		ObjectiveTestExample.Criteria criteria = objectiveTestExample.createCriteria(); 
		criteria.andPartIdEqualTo(partId);
		objectiveTestExample.setOrderByClause("sn desc");
		
		try {
			return new ObjectiveTestListData(objectiveTestService.selectObjectiveTest(objectiveTestExample));
		} catch (Exception e) {
			log.error("CourseCategoryCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据{part_id}删除部分，接口仅开放给运营用户adminUser", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{part_id}", method=RequestMethod.DELETE)
	@AuthRequired(role=RoleType.manager)
	public Object partsDelete(@PathVariable("part_id") Long partId) {
		try {
			return partService.partDelete(partId);
		} catch (Exception e) {
			log.error("PartCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增部分，接口仅开放给运营用户adminUser", response=Part.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.POST)
	@AuthRequired(role=RoleType.manager)
	public Object partsPost(@RequestBody PartParam body, @ApiIgnore @RequestHeader("admin_user_id") Long userId) {
		try {
			return partService.part(body, userId);
		} catch (Exception e) {
			log.error("PartCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="修改部分，接口仅开放给运营用户adminUser", response=Part.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{part_id}", method=RequestMethod.PUT)
	@AuthRequired(role=RoleType.manager)
	public Object partsPut(@PathVariable("part_id") Long partId,  @RequestBody PartModifyParam body, @ApiIgnore @RequestHeader("admin_user_id") Long userId) {
		try {
			return partService.part(partId, body, userId);
		} catch (Exception e) {
			log.error("PartCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="上传视频，保存课程视频关系表", response=Part.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="savePart", method=RequestMethod.POST)
	//@AuthRequired(role=RoleType.manager)
	public Object savePart(@RequestBody PartParam body, @ApiIgnore @RequestHeader("admin_user_id") Long userId) {
		try {
			return partService.savePart(body, userId);
		} catch (Exception e) {
			log.error("PartCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	} 
}
