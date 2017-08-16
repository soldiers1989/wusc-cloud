package com.cxc.chat.exception;

public class DuplicateFriendException extends RuntimeException {
	private static final long serialVersionUID = 7751029145478810541L;
	public DuplicateFriendException() {
		super();
	}
	public DuplicateFriendException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public DuplicateFriendException(String message, Throwable cause) {
		super(message, cause);
	}
	public DuplicateFriendException(String message) {
		super(message);
	}
	public DuplicateFriendException(Throwable cause) {
		super(cause);
	}
}
