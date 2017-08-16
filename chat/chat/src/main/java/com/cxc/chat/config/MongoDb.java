package com.cxc.chat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@ConfigurationProperties(prefix="mongodb")
public class MongoDb {
	private String host;
	private Integer port;
	private String name;
	//private MongoClient mongoClient;
	private MongoTemplate mongoTemplate;
	 
	public Mongo mongo() throws Exception {
		return new MongoClient(host , port);
	}
	
	@Bean
	public MongoTemplate mongoTemplate () throws Exception{
		mongoTemplate =  new MongoTemplate(mongo(),name);
		return mongoTemplate;
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
