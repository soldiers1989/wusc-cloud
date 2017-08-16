package com.cxc.auth;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(ElementType.METHOD)
public @interface AuthRequired {
	/**
	 * 支持的角色，或
	 * @return
	 */
	public RoleType[] role() default {};
	/*public String[] actions() default "";*/
}
