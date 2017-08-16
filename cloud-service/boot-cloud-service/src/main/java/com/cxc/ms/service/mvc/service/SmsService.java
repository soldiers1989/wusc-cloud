package com.cxc.ms.service.mvc.service;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cxc.ms.service.sms.Sms;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SmsService {

	private static final Logger log = LoggerFactory.getLogger(SmsService.class);
	
	@Value("${college.sms.desc}")
	private String veriDesc;
	
	@Value("${college.sms.expire}")
	private Long expire;
	
	@Resource
    private RestTemplate restTemplate;
	@Resource
	private SmsRemoteService smsRemoteService;
	
/*	@HystrixCommand(fallbackMethod = "fail")
	public boolean sendVeriCode(String code, String mobile) {
		Sms sms = new Sms();
		sms.setContent(String.format(veriDesc, code, expire/600000));
		sms.setMobile(mobile);
		Map<String, String> map = new HashMap<>();
		String result = restTemplate.postForEntity(String.format("http://sms/sms/one?mobile=%s&content=%s", mobile, sms.getContent()) , null, String.class, map).getBody();
		return StringUtils.contains(result, "true");
	}*/
	@HystrixCommand(fallbackMethod = "fail")
	public boolean sendVeriCode(String code, String mobile) {
		Sms sms = new Sms();
		sms.setContent(String.format(veriDesc, code, expire/600000));
		sms.setMobile(mobile);
		Object ret = smsRemoteService.one(sms.getMobile(), sms.getContent());
		if (ret != null) {
			return StringUtils.contains(ret.toString(), "true");
		}
		return false;
	}
	
	public boolean fail(String code, String mobile) {
		log.error("send verification code error!mobile:{},code:{}", mobile, code);
		return false;
	}
}
