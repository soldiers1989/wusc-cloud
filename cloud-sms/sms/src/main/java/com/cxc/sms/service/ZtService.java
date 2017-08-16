package com.cxc.sms.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cxc.sms.Sms;
import com.cxc.sms.util.HttpRequest;
import com.cxc.sms.util.Md5Util;
import com.cxc.sms.util.SmsUtil;

/**
 * 助通sms服务
 * @author Leo
 *
 */
@Service
public class ZtService implements SendService{
	private static final Logger log = LoggerFactory.getLogger(ZtService.class);
	
	private static final String paramFormat = "username=%s&password=%s&tkey=%s&mobile=%s&content=%s";
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	
	@Value("${cxc.sms.zt.url}")
	private String url;
	@Value("${cxc.sms.zt.username}")
	private String username;  //账e号
	@Value("${cxc.sms.zt.password}")
	private String password;  //密码
	@Value("${cxc.sms.zt.weight}")
	private Integer weight;
	
	/**
	 * 发送单挑短信
	 * @param sms
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@Override
	public boolean sendOne(Sms sms) throws UnsupportedEncodingException {
		if (StringUtils.isNotBlank(sms.getContent()) && SmsUtil.isValidMobile(sms.getMobile())) {
			String contentUrlEncode = URLEncoder.encode(sms.getContent(), "UTF-8");
			String tkey = dateFormat.format(new Date());
			String passwordMd5 = Md5Util.getMD5String(Md5Util.getMD5String(password).toLowerCase()+tkey).toLowerCase();
			String params = String.format(paramFormat, username, passwordMd5, tkey, sms.getMobile(), contentUrlEncode);
			String result=HttpRequest.sendPost(url,params);
			log.warn("mobile:{},content:{},result:{}", sms.getMobile(), sms.getContent(), result);
			return result.startsWith("1,");
		}
		return false;
	}

	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
}
