/**
 * 
 */
package com.cxc.ms.service.mvc.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxc.auth.RoleType;
import com.cxc.ms.service.mvc.dao.UserMapper;
import com.cxc.ms.service.mvc.dao.VerificationMapper;
import com.cxc.ms.service.mvc.expt.BusinessException;
import com.cxc.ms.service.mvc.model.User;
import com.cxc.ms.service.mvc.model.UserExample;
import com.cxc.ms.service.mvc.model.Verification;
import com.cxc.ms.service.mvc.ret.Result;
import com.cxc.ms.service.mvc.ret.UserSelf;
import com.cxc.ms.service.mvc.vo.ChatUser;
import com.cxc.ms.service.mvc.vo.PasswordParam;
import com.cxc.ms.service.mvc.vo.RegParam;
import com.cxc.ms.service.mvc.vo.StudentParam;
import com.cxc.ms.service.mvc.vo.UserParam;
import com.cxc.ms.service.mvc.vo.VeriParam;
import com.cxc.util.DateUtil;
import com.cxc.util.ParamUtil;
import com.cxc.util.PasswordUtil;
import com.cxc.util.PhoneUtil;
import com.cxc.util.RandomCodeUtil;
import com.cxc.util.ResultUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * <pre>
 * 用户service
 * @author Leo
 * 2017-4-17
 * </pre>
 */
@Service
public class UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Resource
	private RedisService redisService;
	
	@Resource
	private SessionService sessionService;
	
	@Resource
	private VerificationMapper verificationMapper;
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private ObjectMapper objectMapper;
	
	@Resource
	private SmsService smsService;
	
	@Value("${college.sms.expire}")
	private Long verificationExpire;
	@Resource
	private ChatUserRemoteService chatUserRemoteService;
	
	/**
	 * 发送验证码
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object verification(VeriParam param) throws Exception {
		if (PhoneUtil.isValidPhone(param.getPhone())) {
			String code = RandomCodeUtil.randomCode(6);
			Long now = System.currentTimeMillis();
			Verification verification = new Verification();
			verification.setVerificationCode(code);
			verification.setUpdated(now);
			verification.setExpire(now + verificationExpire);
			verification.setStatus(Verification.STATUS_UNCONSUMED);
			verification.setPhone(param.getPhone());
			if (verificationMapper.insertSelective(verification) == 1 && smsService.sendVeriCode(code, param.getPhone())) {
				
				return ResultUtil.EMPTY_RESULT;
			} else {
				return ResultUtil.SYSTEM_ERROR;
			}
		} else {
			return ResultUtil.INVALID_PHONE_ERROR;
		}
	}
	
	/**
	 * 注册新用户
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public Object regist(RegParam param) throws Exception {
		/*
		 * 1.检查参数合法性 2.检查验证码 3.检查手机号是否已注册 4.插入用户 5.注册聊天用户 6.消费验证码 7.执行登录
		 */
		//1.检查参数合法性
		if (!sessionService.loginParamValid(param) || !ParamUtil.eqLength(param.getVerificationCode(), 6)) {
			return ResultUtil.PARAM_ERROR;
		}
		//2.检查验证码
		Long veriId = checkVerificationOnly(param.getPhone(), param.getVerificationCode());
		if (veriId == null) {
			return ResultUtil.VEVIFICATION_ERROR;
		}
		//3.检查手机号是否已注册
		if (checkPhoneExists(param.getPhone())) {
			return ResultUtil.REGED_PHONE_ERROR;
		}
		//4.插入用户
		User user = new User();
		user.setPassword(PasswordUtil.generate(param.getPassword()));
		user.setPhone(param.getPhone());
		user.setRegistrationTime(DateUtil.current());
		user.setUserLevel(User.USERLEVEL_DEFAULT);
		user.setUserType(User.USERTYPE_STUDENT);
		user.setStatus(User.USERSTATUS_ZOMBILE);
		if (userMapper.insertSelective(user) != 1) {
			throw new BusinessException();
		}
		//5.注册聊天用户
		ChatUser chatUser = new ChatUser();
		chatUser.setUsername(param.getPhone());
		chatUser.setPassword(param.getPhone());
		Result result = chatUserRemoteService.addChatUser(chatUser);
		if (result == null || result.getCode() == null || result.getCode() != 200) {
			throw new BusinessException("add chat user fail!");
		}
		//6.消费验证码
		consumeVerification(veriId);
		//7.执行登录
		return sessionService.loginSuccess(param, user, RoleType.learner.name());
	}
	
	/**
	 * 查看某个用户，不做任何信息隐藏（除了密码）
	 * @return
	 * @throws Exception
	 */
	public Object user(Long userId) throws Exception {
		/**
		 * 1.判断userId是否有效 2.查询数据 3.返回结果
		 */
		if (userId > 0) {
			User u = userMapper.selectUserSelfById(userId);
			if (u != null) return u;
		}
		return ResultUtil.NO_DATA_ERROR;
	}
	
	public Object userInfo(Long userId) throws Exception {
		if (userId > 0) {
			User u = userMapper.selectByPrimaryKey(userId);
			if (u != null) return u;
		}
		return ResultUtil.NO_DATA_ERROR;
	}
	
	
	/**
	 * 根据条件获取所有用户，支持分页
	 * @param example
	 * @param offset
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public Map<String,Object> users(UserExample example, Integer offset) throws Exception {
		//支持分页
		if(offset == null){
			offset = 0;
		}
		Map<String,Object> mapData = new HashMap<String,Object>();
		Page<UserSelf> page = PageHelper.offsetPage(offset, 20);
		userMapper.selectByExample(example);
		mapData.put("size", page.toPageInfo().getTotal());
		mapData.put("users", page.toPageInfo().getList());
		return mapData;
	}
	
	/**
	 * 根据用户ID删除用户
	 * @param userId
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public Object deleteUserById(Long userId) throws Exception {
		User user = new User();
		user.setUserId(userId);
		user.setStatus(User.USERSTATUS_DELETED);
		if(userMapper.updateByPrimaryKeySelective(user) == 1){
			return ResultUtil.EMPTY_RESULT;			
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public Object insertUser(StudentParam param) throws Exception {
		if(!ParamUtil.checkParamValid(param, null)){
			return ResultUtil.PARAM_ERROR;
		}
		User user = new User();
		user.setUserName(param.getUserName());
		user.setOrganizationId(param.getOrganizationId());
		user.setMajor(param.getMajor());
		user.setPhone(param.getPhone());
		user.setPassword(param.getPassword());
		user.setSno(param.getSno());
		user.setEmail(param.getEmail());
		user.setUserType((short)1);
		user.setStatus((short)0);
		user.setRegistrationTime(DateUtil.current());
		user.setUserLevel((long)0);
		User info = userMapper.selectByPhone(param.getPhone());
		if(info != null){
			return ResultUtil.SYSTEM_ERROR;
		}
		if(userMapper.insertSelective(user) == 1){
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;		
	}
	
	/**
	 * 编辑用户信息，更新用户
	 * @param param
	 * @return
	 * @throws Exception
	 * @author linmei.yan
	 */
	public Object updateUser(Long userId,StudentParam param) throws Exception {
		if(!ParamUtil.checkParamValid(param, null) || userId < 1){
			return ResultUtil.PARAM_ERROR;
		}
		User user = new User();
		user.setUserId(userId);
		user.setUserName(param.getUserName());
		user.setOrganizationId(param.getOrganizationId());
		user.setMajor(param.getMajor());
		user.setPhone(param.getPhone());
		user.setPassword(param.getPassword());
		user.setSno(param.getSno());
		user.setEmail(param.getEmail());
		user.setNickname(param.getNickname());
		user.setStatus(param.getStatus());
		if(userMapper.updateByPrimaryKeySelective(user) == 1){
			return ResultUtil.EMPTY_RESULT;
		}
		return ResultUtil.SYSTEM_ERROR;	
	}
	
	/**
	 * 修改个人信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object user(UserParam param, HttpServletRequest request) throws Exception {
		/**
		 * 1.判断参数有效性 2.插入数据
		 */
		if (ParamUtil.checkParamValid(param, request)) {
			User now = userMapper.selectByPrimaryKey(param.getUserId());
			if (now.getStatus() == User.USERSTATUS_PASSED) {//已经审核通过的用户不允许再次修改
				return ResultUtil.NO_AUTH_ERROR;
			}
			User user = new User();
			user.setEmail(trimToNull(param.getEmail()));
			user.setMajor(trimToNull(param.getMajor()));
			user.setNickname(trimToNull(param.getNickname()));
			user.setPhotoUrl(trimToNull(param.getPhotoUrl()));
			user.setRealName(trimToNull(param.getRealName()));
			user.setResume(trimToNull(param.getResume()));
			user.setOrganizationId(param.getOrganizationId());
			user.setSno(trimToNull(param.getSno()));
			user.setUserId(param.getUserId());
			user.setUserName(trimToNull(param.getUserName()));
			user.setStatus(User.USERSTATUS_COMMON);
			if (userMapper.updateByPrimaryKeySelective(user) == 1) {
				return ResultUtil.EMPTY_RESULT;
			}
		} else {
			return ResultUtil.PARAM_ERROR;
		}
		return ResultUtil.SYSTEM_ERROR;
	}
	
	private String trimToNull(String string) {
		if (string == null || "".equals(string.trim())) {
			return null;
		}
		return string;
	}
	
	/**
	 * 检查验证码是否有效，不消费
	 * @param phone
	 * @param code
	 * @return
	 */
	private Long checkVerificationOnly(String phone, String code) {
		Long id = verificationMapper.selectVerificationIdByPhoneAndExpire(phone, code, System.currentTimeMillis(),
				Verification.STATUS_UNCONSUMED);
		return id;
	}
	
	/**
	 * 消费验证码
	 * @param vid
	 * @return
	 */
	private boolean consumeVerification(Long id) {
		if (id != null) {
			Verification v = new Verification();
			v.setVerificationId(id);
			v.setUpdated(System.currentTimeMillis());
			v.setStatus(Verification.STATUS_CONSUMED);
			return verificationMapper.updateByPrimaryKeySelective(v) == 1;
		}
		return false;
	}
	
	private boolean checkPhoneExists(String phone) {
		return userMapper.selectUserIdByPhone(phone) != null;
	}
	
	@Transactional
	public Object passwordUpdate(PasswordParam param) throws Exception{
		/**
		 * 1.检查参数合法性 2.查询核对验证码 3.修改密码并修改验证码表 4.返回结果
		 */
		//1.检查参数合法性
		if (!ParamUtil.checkParamValid(param, null)) {
			return ResultUtil.PARAM_ERROR;
		}
		//2.查询核对验证码 
		Long vid = checkVerificationOnly(param.getMobile(), param.getVerificationCode());
		if (vid == null) {
			return ResultUtil.VEVIFICATION_ERROR;
		}
		//3.修改密码并修改验证码表 
		Long userId = userMapper.selectUserIdByPhone(param.getMobile());
		if (userId == null) {
			return ResultUtil.UNKNOWN_PHONE_ERROR;
		}
		User user = new User();
		user.setUserId(userId);
		user.setPassword(PasswordUtil.generate(param.getPasswordNew()));
		if (userMapper.updateByPrimaryKeySelective(user) != 1) {
			return ResultUtil.SYSTEM_ERROR;
		}
		if (!consumeVerification(vid)) {
			log.error("consume verification code error, id:{}", vid);
		}
		return ResultUtil.EMPTY_RESULT;
	}
}
