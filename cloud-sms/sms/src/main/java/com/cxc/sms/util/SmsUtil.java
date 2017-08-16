package com.cxc.sms.util;

import org.apache.commons.lang.StringUtils;

public class SmsUtil {
	public static boolean isValidMobile(String mobile) {
		return StringUtils.isNotBlank(mobile) && mobile.matches("^1[34578]\\d{9}$");
	}
	
	public static boolean isValidMobile(String[] mobile) {
		boolean ret = true;
		for (String str : mobile) {
			if (!isValidMobile(str)) {
				return false;
			}
		}
		return ret;
	}
}
