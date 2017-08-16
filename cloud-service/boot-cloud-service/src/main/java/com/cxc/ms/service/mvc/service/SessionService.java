package com.cxc.ms.service.mvc.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxc.auth.RoleType;
import com.cxc.ms.service.mvc.dao.AdminMapper;
import com.cxc.ms.service.mvc.dao.SessionMapper;
import com.cxc.ms.service.mvc.dao.UserMapper;
import com.cxc.ms.service.mvc.expt.BusinessException;
import com.cxc.ms.service.mvc.model.Admin;
import com.cxc.ms.service.mvc.model.AdminExample;
import com.cxc.ms.service.mvc.model.AdminExample.Criteria;
import com.cxc.ms.service.mvc.model.Session;
import com.cxc.ms.service.mvc.model.User;
import com.cxc.ms.service.mvc.vo.LoginParam;
import com.cxc.ms.service.mvc.vo.LoginParamWeb;
import com.cxc.ms.service.mvc.vo.UserVo;
import com.cxc.util.DateUtil;
import com.cxc.util.ErrorModel;
import com.cxc.util.ParamUtil;
import com.cxc.util.PasswordUtil;
import com.cxc.util.PhoneUtil;
import com.cxc.util.ResultUtil;
import com.cxc.util.TokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SessionService {
	
	private static final Logger log = LoggerFactory.getLogger(SessionService.class);
	
	@Value("${college.session.expire}")
	private Long sessionExpire;
	
	@Value("${college.session.redis.key}")
	private String redisSessionKey;
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private AdminMapper adminMapper;
	
	@Resource
	private SessionMapper sessionMapper;
	
	@Resource
	private RedisService redisService;
	
	@Resource
	private ObjectMapper objectMapper;
	
	/**
	 * 登录，成功返回token
	 * @param ul
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public Object login(LoginParam param) throws Exception {
		/**
		 * 1.判断数据有效性 2.判断密码是否正确 3.执行登录
		 */
		//1.判断数据有效性
		if (!loginParamValid(param)) {
			return ResultUtil.PARAM_ERROR;
		}
		//2.判断密码是否正确
		User user = userMapper.selectByPhone(param.getPhone());
		if (user != null && user.getStatus() == User.USERSTATUS_DELETED ) {
			return new ErrorModel("400", "该用户已被封禁");
		}
		if (user == null || user.getStatus() == User.USERSTATUS_DELETED || !PasswordUtil.verify(param.getPassword(), user.getPassword())) {
			return ResultUtil.LOGIN_ERROR;
		}
		//3.执行登录
		return loginSuccess(param, user, RoleType.learner.name());
	}
	
	/**
	 * web 登录
	 * @param param
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public Object webLogin(LoginParamWeb param) throws Exception {
		if (!ParamUtil.geLength(param.getPassword(), 6)) {
			return ResultUtil.PARAM_ERROR;
		}
		
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		if(param.getAdminName() != null){
			criteria.andAdminNameEqualTo(param.getAdminName());
		}
		List<Admin> admins = adminMapper.selectByExample(example);
		if(admins != null && !admins.isEmpty()){
			Admin admin = admins.get(0);
			if (admin.getStatus() == User.ADMINSTATUS_STOP || !param.getPassword().equals(admin.getPassword())) {
				return ResultUtil.LOGIN_ERROR;
			}
			User user = new User();
			user.setUserId(admin.getAdminId());
			user.setUserName(admin.getAdminName());
			user.setPassword(admin.getPassword());
			user.setPhone(admin.getPhone());
			user.setStatus(admin.getStatus());
			return loginSuccess(new LoginParam(), user, RoleType.manager.name());
		}
		return ResultUtil.LOGIN_ERROR;
	}
	
	/**
	 * 执行登录
	 * @param param
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Object loginSuccess(LoginParam param, User user, String roleName) throws Exception {
		//1.生成token并缓存到redis
		String token = TokenUtil.generateToken();
		Session session = new Session();
		session.setClientIdentifier(param.getClientIdentifier());
		session.setCreateTime(DateUtil.current());
		session.setExpireTime(DateUtil.date(System.currentTimeMillis() + sessionExpire));
		session.setStatus(Session.STATUS_VALID);
		session.setSystemId(Session.COLLEGE_SYSTEM_ID);
		session.setTerminalType(param.getTerminalType());
		session.setToken(token);
		session.setUserId(user.getUserId());
		Set<String> roles = new HashSet<String>();
		roles.add(roleName);
		session.setRoles(roles);
		byte[] key = String.format(redisSessionKey, token).getBytes();
		byte[] values = objectMapper.writeValueAsBytes(session);
		boolean suc = redisService.redis(a -> {
			String ret = a.set(key, values, "NX".getBytes(), "PX".getBytes(), sessionExpire.longValue());
			log.info("-------" + ret.trim() + "-------");
			return "OK".equals(ret == null ? null : ret.trim());
		});
		if (!suc) {
			throw new BusinessException();
		}
		try {
			//2.插入session记录
			if (sessionMapper.insertSelective(session) != 1) {
				throw new BusinessException();
			}
		} catch (Exception e) {
			redisService.removeKey(key);
			throw e;
		}
		//3.返回token
		UserVo uv = new UserVo(user);
		uv.setClientIdentifier(session.getClientIdentifier());
		uv.setCreateTime(session.getCreateTime());
		uv.setExpireTime(session.getExpireTime());
		uv.setSessionId(session.getSessionId());
		uv.setSystemId(session.getSystemId());
		uv.setTerminalType(session.getTerminalType());
		uv.setToken(session.getToken());
		return uv;
	}
	
	/**
	 * 退出app操作
	 * @param token
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public Object logout(String token, Long userId) throws Exception{
		/**
		 * 1.修改数据库记录 2.删除redis缓存
		 */
		//1.修改数据库记录
		Long sessionId = sessionMapper.selectByUserIdAndToken(token, userId);
		if (sessionId != null) {
			Session ss = new Session();
			ss.setSessionId(sessionId);
			ss.setStatus(Session.STATUS_INVALID);
			sessionMapper.updateByPrimaryKeySelective(ss);
		}
		//2.删除redis缓存
		byte[] key = String.format(redisSessionKey, token).getBytes();
		redisService.removeKey(key);
		return ResultUtil.EMPTY_RESULT;
	}
	
	public boolean loginParamValid(LoginParam param) {
		return PhoneUtil.isValidPhone(param.getPhone()) && ParamUtil.geLength(param.getPassword(), 6) 
		&& ParamUtil.leLength(param.getTerminalType(), 10) && ParamUtil.leLength(param.getClientIdentifier(), 40) &&
		ParamUtil.leLength(param.getCity(), 20) && ParamUtil.leLength(param.getProvince(), 20) &&
		ParamUtil.leLength(param.getModel(), 20) && ParamUtil.leLength(param.getOs(), 10);
	}
}
