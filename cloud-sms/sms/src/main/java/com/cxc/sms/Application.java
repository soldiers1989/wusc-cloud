package com.cxc.sms;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication(scanBasePackages="com.cxc")
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.cxc")
public class Application {
	static {
		//连接超时及读取超时设置
		System.setProperty("sun.net.client.defaultConnectTimeout", "30000"); //连接超时：30秒
		System.setProperty("sun.net.client.defaultReadTimeout", "30000");	//读取超时：30秒
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
