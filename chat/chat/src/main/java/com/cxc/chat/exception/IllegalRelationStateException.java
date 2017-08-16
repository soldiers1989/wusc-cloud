package com.cxc.chat.exception;

public class IllegalRelationStateException extends RuntimeException {
	private static final long serialVersionUID = 6711800061720947901L;
	public IllegalRelationStateException() {
		super();
	}
	public IllegalRelationStateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public IllegalRelationStateException(String message, Throwable cause) {
		super(message, cause);
	}
	public IllegalRelationStateException(String message) {
		super(message);
	}
	public IllegalRelationStateException(Throwable cause) {
		super(cause);
	}
}
