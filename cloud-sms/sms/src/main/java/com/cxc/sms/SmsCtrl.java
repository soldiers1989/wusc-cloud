package com.cxc.sms;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cxc.sms.service.SmsService;

@RestController
@RequestMapping("/sms")
public class SmsCtrl {

	private static final Logger log = LoggerFactory.getLogger(SmsCtrl.class);
	
	@Resource
	private SmsService smsService;
	
	@RequestMapping(value="one", method=RequestMethod.POST)
	public Object mlrt(Sms sms) {
		try {
			return smsService.sendOne(sms);
		} catch (Exception e) {
			log.error("send sms error!", e);
		}
		return false;
	}
}
