package com.cxc.util;

public class RedisResult {
	private Integer code;
	private Object data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public RedisResult(Integer code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
