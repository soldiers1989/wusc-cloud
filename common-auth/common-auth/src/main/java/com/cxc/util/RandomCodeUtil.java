package com.cxc.util;

import org.apache.commons.lang.RandomStringUtils;

public class RandomCodeUtil {

	private static final char[] digits = {'0','1','2','3','4','5','6','7','8','9'};
	
	public static final String randomCode(int length) {
		return RandomStringUtils.random(length, digits);
	}
}
