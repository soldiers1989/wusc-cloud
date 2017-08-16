package com.cxc.chat.exception;

public class IllegalArgumentException extends RuntimeException {
	private static final long serialVersionUID = 2011522246710718872L;

	public IllegalArgumentException() {
		super();
	}

	public IllegalArgumentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalArgumentException(String message) {
		super(message);
	}

	public IllegalArgumentException(Throwable cause) {
		super(cause);
	}
}
