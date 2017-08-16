package com.cxc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.cxc")
public class App 
{
	
    public static void main( String[] args )
    {
    	new SpringApplicationBuilder(App.class).web(true).run(args);
    }
}
