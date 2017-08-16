/**
 * 
 */
package com.cxc.chat.exception;

/**
 * @author china
 * 2017-6-21
 */
public class FriendsCountMaxException extends RuntimeException {
	private static final long serialVersionUID = -4598888306995341022L;
	public FriendsCountMaxException() {
		super();
	}
	public FriendsCountMaxException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public FriendsCountMaxException(String message, Throwable cause) {
		super(message, cause);
	}
	public FriendsCountMaxException(String message) {
		super(message);
	}
	public FriendsCountMaxException(Throwable cause) {
		super(cause);
	}
}
