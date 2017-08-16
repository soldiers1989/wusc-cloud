package com.cxc.ms.service.mvc.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sms", fallback=SmsRemoteServiceFail.class)
public interface SmsRemoteService {
	@RequestMapping(value="/sms/one", method=RequestMethod.POST)
	public Object one(@RequestParam("mobile") String mobile, @RequestParam("content") String content);
}
