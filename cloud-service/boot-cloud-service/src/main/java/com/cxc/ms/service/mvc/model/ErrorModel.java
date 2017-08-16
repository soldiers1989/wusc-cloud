/**
 * 
 */
package com.cxc.ms.service.mvc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * <pre>
 * 错误model
 * @author Leo
 * 2017-4-17
 * </pre>
 */
@JsonInclude(Include.NON_EMPTY)
public class ErrorModel {

	/**
	 * 错误编码
	 */
	private String errorCode;
	
	/**
	 * 错误信息
	 */
	private String errorMsg;
	
	public ErrorModel() {
		super();
	}
	public ErrorModel(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
