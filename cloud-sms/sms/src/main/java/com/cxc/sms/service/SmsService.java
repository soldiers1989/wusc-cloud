package com.cxc.sms.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cxc.sms.Sms;
import com.cxc.sms.util.RandomUtil;

import redis.clients.jedis.Jedis;

/**
 * 短信发送接口
 * @author Leo
 * 2017-4-21
 */
@Service
public class SmsService {

	private static final Logger log = LoggerFactory.getLogger(SmsService.class);
	
	@Resource
	private MlrtService mlrtService;
	@Resource
	private ZtService ztService;
	@Resource
	private Jedis jedis;
	
	private final String SMS_SEND_HISTORY_IP = "college.sms.history.ip:%s";
	
	public boolean sendOne(Sms sms) {
		//判断该ip是不是1天内发送了200次，是的话不发，否则发
/*		try {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			String ip = request.getHeader("Real_Ip");
			String key = String.format(SMS_SEND_HISTORY_IP, ip);
			Long num = jedis.incr(key);
			if (num >= 200) {
				return false;
			} else {
				jedis.expire(key, 24*3600);
			}
		} catch (Exception e) {
			log.error("SmsService error", e);
		}*/
		
		SendService[] ss = new SendService[]{mlrtService, ztService}; 
		boolean first = RandomUtil.selectByWeight(mlrtService.getWeight(), ztService.getWeight());
		if (!first) {
			ArrayUtils.reverse(ss);
		}
		for (SendService s : ss) {
			try {
				if (s.sendOne(sms)) return true;
			} catch (Exception e) {
				log.error("SmsService error", e);
			}
		}

		return false;
	}
}
