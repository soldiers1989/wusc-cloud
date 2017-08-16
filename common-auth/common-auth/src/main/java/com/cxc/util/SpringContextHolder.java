package com.cxc.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextHolder implements ApplicationContextAware {

	private static ApplicationContext context;
	
	public static <T> T getBean(String name, Class<T> requiredType) {
		return context.getBean(name, requiredType);
	}
	
	public static <T> T getBean(Class<T> requiredType) {
		return context.getBean(requiredType);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

}
