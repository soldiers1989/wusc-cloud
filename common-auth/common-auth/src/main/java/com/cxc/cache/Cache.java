package com.cxc.cache;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <pre>
 * 缓存用注解，可以放在controller或者service方法中
 * 要求：数据异常时必须返回ErrorModel,否则会将错误数据缓存，造成致命bug
 * </pre>
 * @author wanglei
 *
 */
@Documented
@Retention(RUNTIME)
@Target(ElementType.METHOD)
public @interface Cache {

	/**
	 * cache time(ms),default 60000ms(1min)
	 * @return
	 */
	public long time() default 60000L;
	
	/**
	 * cache key(maybe unique )
	 * @return
	 */
	public String key() default "";
	
	/**<pre>
	 * type to return
	 * </pre>
	 * @return
	 */
	public Class<?> type();
}
