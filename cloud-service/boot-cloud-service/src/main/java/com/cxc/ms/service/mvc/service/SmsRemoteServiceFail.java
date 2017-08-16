package com.cxc.ms.service.mvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("smsRemoteServiceFail")
public class SmsRemoteServiceFail implements SmsRemoteService{
	private static final Logger log = LoggerFactory.getLogger(SmsRemoteServiceFail.class);
	public Object one(String mobile, String content) {
		log.error("SmsRemoteServiceFail");
		return null;
	}
}
