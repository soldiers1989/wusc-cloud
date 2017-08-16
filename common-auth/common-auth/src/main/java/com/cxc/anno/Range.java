package com.cxc.anno;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Range {

	public long min() default Long.MIN_VALUE;
	
	public long max() default Long.MAX_VALUE;
}
