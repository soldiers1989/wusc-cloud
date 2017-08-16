package com.cxc.video;

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
public class Application 
{
    public static void main( String[] args )
    {
    	new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
