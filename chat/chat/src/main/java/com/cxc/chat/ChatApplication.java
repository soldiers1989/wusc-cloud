package com.cxc.chat;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.cxc")
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.cxc")
public class ChatApplication 
{
    public static void main( String[] args )
    {
    	new SpringApplicationBuilder(ChatApplication.class).web(true).run(args);
    }
}
