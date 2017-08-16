package com.cxc.util;

import java.util.regex.Pattern;

public class PhoneUtil {

	private static Pattern p = Pattern.compile("^1[3578][0-9]{9}$");
	
	/**
	 * 判断一个手机号是否正确
	 * @param phone
	 * @return
	 */
	public static boolean isValidPhone(String phone) {
		return p.matcher(phone).find();
	}
}
