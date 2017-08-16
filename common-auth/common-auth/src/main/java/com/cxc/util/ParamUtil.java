package com.cxc.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.cxc.anno.EqualHeader;
import com.cxc.anno.Range;
import com.cxc.anno.Required;
import com.cxc.anno.StringLength;

public class ParamUtil {

	public static boolean geLength(String str, int length) {
		return StringUtils.isNotBlank(str) && str.length() >= length;
	}
	
	public static boolean leLength(String str, int length) {
		return StringUtils.isBlank(str) || str.trim().length() <= length;
	}
	
	public static boolean eqLength(String str, int length) {
		return StringUtils.isNotBlank(str) && str.length() == length;
	}
	
	public static boolean checkParamValid(Object obj, HttpServletRequest request) throws Exception{
		if (obj == null) return false;
		Field[] fs = obj.getClass().getDeclaredFields();
		for (Field f : fs) {
			f.setAccessible(true);
			Annotation[] annos = f.getDeclaredAnnotations();
			for (Annotation anno : annos) {
				if (anno instanceof Range) {
					Range range = (Range) anno;
					Object value = f.get(obj);
					if (value != null) {
						long num = ((Number) value).longValue();
						if (num < range.min() || num > range.max()) {
							return false;
						}
					}
				} else if (anno instanceof StringLength) {
					StringLength l = (StringLength) anno;
					Object value = f.get(obj);
					if (value != null) {
						int length = value.toString().length();
						if (length < l.min() || length > l.max()) {
							return false;
						}
					}
				} else if (anno instanceof Required) {
					Object value = f.get(obj);
					if (value != null) {
						if (value instanceof String) {
							if (StringUtils.isBlank(value.toString())) {
								return false;
							}
						}
					} else {
						return false;
					}
				} else if (anno instanceof EqualHeader) {
					EqualHeader eh = (EqualHeader) anno;
					Object value = f.get(obj);
					if (value != null) {
						String h = request.getHeader(eh.value());
						if (!value.toString().equals(h)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
