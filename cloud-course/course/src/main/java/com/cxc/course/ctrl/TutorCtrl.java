package com.cxc.course.ctrl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.auth.AuthRequired;
import com.cxc.auth.RoleType;
import com.cxc.course.model.Tutor;
import com.cxc.course.model.TutorExample;
import com.cxc.course.model.TutorExample.Criteria;
import com.cxc.course.param.TutorModifyParam;
import com.cxc.course.param.TutorParam;
import com.cxc.course.service.TutorService;
import com.cxc.util.ResultUtil;
import com.cxc.vo.TutorListData;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value="tutors", headers="Accept=application/json; version=1.0")
public class TutorCtrl {
private static final Logger log = LoggerFactory.getLogger(TutorCtrl.class);
	
	@Resource
	private TutorService tutorService;
	
	@ApiOperation(value="根据讲师ID、名称获取所有符合条件的所有讲师列表", response=Tutor.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true)
	})
	@RequestMapping(method=RequestMethod.GET)
	public Object getTutors(@ApiIgnore @RequestHeader(value="user_id",required=false) Long userId, @RequestParam(value="tutor_id",required=false) Long tutorId, @RequestParam(value="tutor_name",required=false) String tutorName,@RequestParam(value="offset", required=false) Integer offset){
		TutorExample tutorExample = new TutorExample();
		Criteria criteria = tutorExample.createCriteria();
		if (tutorId != null){
			criteria.andTutorIdEqualTo(tutorId);	
			tutorExample.setOrderByClause("tutor_id asc");
		}
		if(tutorName != null){
			criteria.andTutorNameLike("%"+tutorName+"%");
		}
		try {
//			Map<String,Object> mapData = tutorService.selectTutors(tutorExample, offset);
			return tutorService.selectTutors(tutorExample, offset);
		} catch (Exception e) {
			log.error("TutorCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据讲师ID列表{id1,id2,id3}，获取讲师列表", response=Tutor.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="tutorIdLst/{tutor_id_list}", method=RequestMethod.GET)
	public Object getTutorsByIDs(@PathVariable(value="tutor_id_list", required=true) String tutorIDLst){
		TutorExample tutorExample = new TutorExample();
		Criteria criteria = tutorExample.createCriteria();
		if(tutorIDLst != null){
			List<Long> listIds = Arrays.asList(tutorIDLst.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList()); 
			criteria.andTutorIdIn(listIds);
		}
		try {
			return tutorService.selectTutors(tutorExample, null);
		} catch (Exception e) {
			log.error("TutorCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据{tutor_id}获取讲师", response=Tutor.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="{tutor_id}", method=RequestMethod.GET)
	public Object tutors(@PathVariable("tutor_id") Long tutorId) {
		try {
			return tutorService.tutor(tutorId);
		} catch (Exception e) {
			log.error("TutorCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据{tutor_id}删除讲师，接口仅开放给运营用户adminUser", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{tutor_id}", method=RequestMethod.DELETE)
	@AuthRequired(role=RoleType.manager)
	public Object tutorsDelete(@PathVariable("tutor_id") Long tutorId) {
		try {
			return tutorService.tutorDelete(tutorId);
		} catch (Exception e) {
			log.error("TutorCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增讲师，接口仅开放给运营用户adminUser", response=Tutor.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(method=RequestMethod.POST)
	@AuthRequired(role=RoleType.manager)
	public Object tutorsPost(@RequestBody TutorParam body) {
		try {
			return tutorService.tutor(body);
		} catch (Exception e) {
			log.error("TutorCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="修改讲师，接口仅开放给运营用户adminUser", response=Tutor.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="admin_token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="admin_user_id", required=true),
	})
	@RequestMapping(path="{tutor_id}", method=RequestMethod.PUT)
	@AuthRequired(role=RoleType.manager)
	public Object tutorsPut(@PathVariable("tutor_id") Long tutorId,  @RequestBody TutorModifyParam body) {
		try {
			return tutorService.tutor(tutorId, body);
		} catch (Exception e) {
			log.error("TutorCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
