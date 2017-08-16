package com.cxc.util;

import java.util.UUID;

public class TokenUtil {

	public static final String generateToken() {
		return Md5Util.getMD5String(UUID.randomUUID().toString()).toLowerCase();
	}
}
