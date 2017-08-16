package com.cxc.ms.service.mvc.vo;

public abstract class DataWrap<T> {
	private T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
