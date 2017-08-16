/**
 * 
 */
package com.cxc.ms.service.mvc.ctrl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.ms.service.mvc.model.User;
import com.cxc.ms.service.mvc.model.UserExample;
import com.cxc.ms.service.mvc.model.UserExample.Criteria;
import com.cxc.ms.service.mvc.model.UserSuggestion;
import com.cxc.ms.service.mvc.ret.UserSelf;
import com.cxc.ms.service.mvc.service.OrganizationService;
import com.cxc.ms.service.mvc.service.RedisService;
import com.cxc.ms.service.mvc.service.SuggestService;
import com.cxc.ms.service.mvc.service.UserService;
import com.cxc.ms.service.mvc.vo.UserParam;
import com.cxc.ms.service.mvc.vo.StudentParam;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * <pre>
 * 用户控制器入口
 * @author Leo
 * </pre>
 */
@RestController("collegeUserCtrl")
@RequestMapping(value="/users", headers="Accept=application/json; version=1.0", produces="application/json")
public class UserCtrl {
	
	private static final Logger log = LoggerFactory.getLogger(UserCtrl.class);
	
	public UserCtrl() {
	}
	
	@Resource
	private UserService userService;
	@Resource
	private RedisService redisService;
	@Resource
	private SuggestService suggestService;
	
	@Resource
	private OrganizationService organizationService;
	
	@ApiOperation(value="根据姓名、手机、学校/单位、学号/工号，获取所有符合条件的用户", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="users", method=RequestMethod.GET)
	public Object users(@RequestParam(value="user_name",required=false) String userName, @RequestParam(value="phone",required=false) String phone, Long organizationId, String sno, Integer offset, Boolean registration_time) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusNotEqualTo(User.USERSTATUS_DELETED);
		if(userName != null){
			criteria.andUserNameLike("%"+userName+"%");
		}
		if(phone != null){
			criteria.andPhoneEqualTo(phone); 
		}

		if(sno != null){
			criteria.andSnoEqualTo(sno);
		}
		if(organizationId != null){
			criteria.andOrganizationIdEqualTo(organizationId);
		}
		if(registration_time != null){
			if(registration_time){
				example.setOrderByClause("registration_time DESC");
			}
			else{
				example.setOrderByClause("registration_time asc");
			}
		}
		try {
//			if(organizationName != null){
//				List<Organization> lstOrg = organizationService.getTotalByOrgName(organizationName);
//				List<Long> values = lstOrg.stream().map(item->item.getId()).collect(Collectors.toList());
//				if(!values.isEmpty()){
//					criteria.andOrganizationIdIn(values);
//				}
//			}
			return userService.users(example, offset);
		} catch (Exception e) {
			log.error("UserCtrl", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据用户ID删除用户", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true)
	})
	@RequestMapping(path="deleteUser/{userId}", method=RequestMethod.DELETE)
	public Object deleteUserById(@PathVariable(value="userId") Long userId){
		try{
			return userService.deleteUserById(userId);
		} catch(Exception e) {
			log.error("UserCtrl deleteUserById", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="新增用户", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true)
	})
	@RequestMapping(value="insertUser",method=RequestMethod.POST)
	public Object insertUser(@RequestBody StudentParam user){
		try{
			return userService.insertUser(user);
		} catch(Exception e){
			log.error("UserCtrl insertUser", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="编辑用户接口，根据userId更新用户信息",response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String",paramType="header",value="令牌",name="token",required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true)		
	})
	@RequestMapping(path="editUser/{userId}", method=RequestMethod.PUT)
	public Object editUser(@PathVariable(value="userId",required=true) Long userId, @RequestBody StudentParam user){
		try {
			return userService.updateUser(userId,user);
		} catch(Exception e) {
			log.error("UserCtrl editUser", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
		
	
	@ApiOperation(value="获取当前用户信息", response=UserSelf.class, notes="users/current")
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(value="current", method={RequestMethod.GET})
	public Object user(@RequestHeader("user_id") Long userId) {
		try {
			return userService.user(userId);
		} catch (Exception e) {
			log.error("UserCtrl user error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="获取当前用户全部信息", response=User.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="info", method={RequestMethod.GET})
	public Object userIfo(@RequestHeader("user_id") Long userId) {
		try {
			return userService.userInfo(userId);
		} catch (Exception e) {
			log.error("UserCtrl user error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	
	@ApiOperation(value="根据用户ID获取用户信息", response=UserSelf.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(path="getUserById/{userId}", method={RequestMethod.GET})
	public Object getUserById(@PathVariable("userId") Long userId) {
		try {
			return userService.user(userId);
		} catch (Exception e) {
			log.error("UserCtrl user error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="完善个人信息", response=Object.class, notes="登录状态有效", tags="users-put")
	/*@ApiImplicitParams({
		@ApiImplicitParam(value="用户ID", paramType="body", required=true, name="user_id"),
		@ApiImplicitParam(value="用户姓名", paramType="body", required=true, name="user_name"),
		@ApiImplicitParam(value="学号", paramType="body", required=false, name="sno"),
		@ApiImplicitParam(value="绰号", paramType="body", required=false, name="nickname"),
		@ApiImplicitParam(value="真实姓名", paramType="body", required=false, name="real_name"),
		@ApiImplicitParam(value="邮箱", paramType="body", required=false, name="email"),
		@ApiImplicitParam(value="学校ID", paramType="body", required=false, name="school_id"),
		@ApiImplicitParam(value="专业", paramType="body", required=false, name="major"),
		@ApiImplicitParam(value="简历", paramType="body", required=false, name="resume"),
		@ApiImplicitParam(value="头像url", paramType="body", required=false, name="photo_url")
	})*/
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
		@ApiImplicitParam(dataType="UserParam", paramType="body", value="用户信息", name="user", required=true),
	})
	@RequestMapping(method=RequestMethod.PUT)
	public Object user(@ApiIgnore @RequestBody UserParam body, HttpServletRequest request) {
		try {
			return userService.user(body, request);
		} catch (Exception e) {
			log.error("UserCtrl user put error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="提建议", response=Object.class, notes="提交建议", tags="users-userSuggestion-post")
	@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true)
	@RequestMapping(value="usersuggestion", method=RequestMethod.POST)
	public Object suggest(@RequestBody UserSuggestion body, @RequestHeader(value="user_id") Long userId) {
		try {
			return suggestService.suggest(body, userId);
		} catch (Exception e) {
			log.error("UserCtrl user put error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据手机号码列表查询所有用户", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(value="users/phones", method=RequestMethod.GET)
	public Object usersByPhones(@RequestParam List<String> phones) {
		if (phones.isEmpty()) return ResultUtil.NO_DATA_ERROR;
		try {
			UserExample example = new UserExample();
			example.createCriteria().andPhoneIn(phones);
			return userService.users(example, 0);
		} catch (Exception e) {
			log.error("UserCtrl error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据id列表查询所有用户", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(value="users/ids", method=RequestMethod.GET)
	public Object usersByIds(@RequestParam List<Long> ids) {
		if (ids.isEmpty()) return ResultUtil.NO_DATA_ERROR;
		try {
			UserExample example = new UserExample();
			example.createCriteria().andUserIdIn(ids);
			return userService.users(example, 0);
		} catch (Exception e) {
			log.error("UserCtrl error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="根据nickname查询所有用户", response=Object.class)
	@ApiImplicitParams({
		@ApiImplicitParam(dataType="String", paramType="header", value="令牌", name="token", required=true),
		@ApiImplicitParam(dataType="Long", paramType="header", value="用户id", name="user_id", required=true),
	})
	@RequestMapping(value="users/nickname", method=RequestMethod.GET)
	public Object usersByNickname(@RequestParam String nickname, @RequestParam(value="offset", required=false) Integer offset) {
		try {
			UserExample example = new UserExample();
			example.createCriteria().andNicknameEqualTo(nickname);
			return userService.users(example, offset);
		} catch (Exception e) {
			log.error("UserCtrl error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
