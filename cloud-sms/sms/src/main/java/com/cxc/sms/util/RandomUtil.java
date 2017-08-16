package com.cxc.sms.util;

import java.util.Random;

public class RandomUtil {

	private static final Random random = new Random(System.currentTimeMillis());
	
	/**
	 * 根据权重随机选择
	 * @param w1
	 * @param w2
	 * @return true:w1;false:w2
	 */
	public static boolean selectByWeight(Integer w1, Integer w2) {
		return random.nextInt(w1 + w2) < w1;
	}
}
