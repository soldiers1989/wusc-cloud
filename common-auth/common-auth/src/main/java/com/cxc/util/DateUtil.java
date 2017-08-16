package com.cxc.util;

import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

	static {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
	}
	
	public static Date current() {
		return new Date(System.currentTimeMillis());
	}
	
	public static Date date(long time) {
		return new Date(time);
	}
}
