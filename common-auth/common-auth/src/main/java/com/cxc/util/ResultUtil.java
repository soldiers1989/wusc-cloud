package com.cxc.util;

public class ResultUtil {

	public static final ErrorModel SYSTEM_ERROR = new ErrorModel("999", "系统异常");
	public static final ErrorModel PARAM_ERROR = new ErrorModel("100", "参数错误");
	public static final ErrorModel VEVIFICATION_ERROR = new ErrorModel("101", "验证码错误或已过期");
	public static final ErrorModel UNKNOWN_PHONE_ERROR = new ErrorModel("201", "手机号未注册");
	public static final ErrorModel INVALID_PHONE_ERROR = new ErrorModel("202", "手机号格式有误");
	public static final ErrorModel REGED_PHONE_ERROR = new ErrorModel("203", "手机号已被注册");
	public static final ErrorModel LOGIN_ERROR = new ErrorModel("210", "用户名或密码错误");
	
	public static final ErrorModel NO_AUTH_ERROR = new ErrorModel("401", "没有权限");
	public static final ErrorModel NO_DATA_ERROR = new ErrorModel("404", "查无数据");
	
	public static final Empty EMPTY_RESULT = new Empty();
}
