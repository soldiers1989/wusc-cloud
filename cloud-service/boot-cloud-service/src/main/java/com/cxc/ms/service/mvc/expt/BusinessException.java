package com.cxc.ms.service.mvc.expt;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = -4911827399867535575L;
	public BusinessException() {
	}
	public BusinessException(Throwable cause) {
		super(cause);
	}
	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public BusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
