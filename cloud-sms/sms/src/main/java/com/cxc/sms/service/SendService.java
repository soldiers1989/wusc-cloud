package com.cxc.sms.service;

import com.cxc.sms.Sms;

public interface SendService {

	public boolean sendOne(Sms sms) throws Exception;
}
