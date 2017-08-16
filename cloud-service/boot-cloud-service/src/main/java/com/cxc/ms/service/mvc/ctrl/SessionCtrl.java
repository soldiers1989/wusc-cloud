package com.cxc.ms.service.mvc.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.ms.service.mvc.service.SessionService;
import com.cxc.ms.service.mvc.service.UserService;
import com.cxc.ms.service.mvc.vo.LoginParam;
import com.cxc.ms.service.mvc.vo.LoginParamWeb;
import com.cxc.ms.service.mvc.vo.PasswordParam;
import com.cxc.ms.service.mvc.vo.RegParam;
import com.cxc.ms.service.mvc.vo.UserVo;
import com.cxc.ms.service.mvc.vo.VeriParam;
import com.cxc.util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <pre>
 * 注册、发送验证码等不需要登陆权限的ctrl
 * @author Leo
 * 2017-4-18
 * </pre>
 */
@RestController
@RequestMapping(headers="Accept=application/json; version=1.0")
public class SessionCtrl {

	private static final Logger log = LoggerFactory.getLogger(SessionCtrl.class);
	
	@Resource
	private UserService userService;
	@Resource
	private SessionService sessionService;
	
	@ApiOperation(value="注册新用户", response=UserVo.class, tags="registrations")
	@RequestMapping(value="registrations", method=RequestMethod.POST)
	public Object registrations(@RequestBody RegParam body) {
		try {
			return userService.regist(body);
		} catch (Exception e) {
			log.error("registrations error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="发送验证码", response=Object.class, tags="verification")
	@RequestMapping(value="verification", method=RequestMethod.POST)
	public Object verification(@RequestBody VeriParam body) {
		try {
			return userService.verification(body);
		} catch (Exception e) {
			log.error("verification error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	
	@ApiOperation(value="web登陆", response=UserVo.class, notes="adminName,password必需", tags="webLogin")
	@ApiImplicitParam(name="body", required=true, value="请求体", dataType="LoginParamWeb", paramType="body")
	@RequestMapping(value="webLogin", method=RequestMethod.POST)
	public Object webLogin(@RequestBody LoginParamWeb body) {
		try {
			return sessionService.webLogin(body);
		} catch (Exception e) {
			log.error("login error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	/**
	 * 
	 * @param body
	 * @return
	 */
	@ApiOperation(value="登陆", response=UserVo.class, notes="phone,password必需，其他非必需，如{ \"city\": \"北京\", \"client_identifier\": \"886655442233551114474852212\", \"model\": \"KNT-UL10C00B344/iPhone8,9\", \"os\": \"ios10.1.0/android7.0\", \"password\": \"8856wwc\", \"phone\": \"18866663333\", \"province\": \"北京\", \"terminal_type\": \"android/ios\", \"os_version\":\"MIUI5.0\"}", tags="login")
	@ApiImplicitParam(name="body", required=true, value="请求体", dataType="LoginParam", paramType="body")
	@RequestMapping(value="login", method=RequestMethod.POST)
	public Object login(@RequestBody LoginParam body) {
		try {
			return sessionService.login(body);
		} catch (Exception e) {
			log.error("login error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="退出", response=Object.class, notes="退出app", tags="logout", nickname="退出app")
	@RequestMapping(value="logout", method=RequestMethod.POST)
	public Object logout(@RequestHeader String token, @RequestHeader("user_id") Long userId) {
		try {
			return sessionService.logout(token, userId);
		} catch (Exception e) {
			log.error("logout error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	@ApiOperation(value="修改/忘记密码", response=Object.class, notes="改密码", tags="password-update")
	@RequestMapping(value="password", method=RequestMethod.POST)
	public Object password(@RequestBody PasswordParam body) {
		try {
			return userService.passwordUpdate(body);
		} catch (Exception e) {
			log.error("password modify error!", e);
		}
		return ResultUtil.SYSTEM_ERROR;
	}
}
