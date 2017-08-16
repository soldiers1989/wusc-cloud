package com.cxc.video.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;

@Configuration
public class AliVideo {

	@Value("${aliyun.video.accessKeyId}")
	private String accessKeyId;
	@Value("${aliyun.video.accessKeySecret}")
	private String accessKeySecret;
	
	@Bean
	public DefaultAcsClient defaultAcsClient() {
		DefaultAcsClient defaultAcsClient = new DefaultAcsClient(DefaultProfile.getProfile("cn-shanghai",accessKeyId,accessKeySecret));
		return defaultAcsClient;
	}
}
