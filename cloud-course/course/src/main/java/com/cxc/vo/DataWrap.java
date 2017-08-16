package com.cxc.vo;

public abstract class DataWrap<T> {
	private T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public DataWrap(T data) {
		super();
		this.data = data;
	}
	public DataWrap() {
		super();
	}
	
}
