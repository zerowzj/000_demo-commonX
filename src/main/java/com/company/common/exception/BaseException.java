package com.company.common.exception;

import com.company.common.log.LogInfo;

/**
 * 基础异常
 * 
 * @author wangzhj
 */
public abstract class BaseException extends RuntimeException {

	/** 错误码 */
	private String errorCode = null;
	
	/** 错误描述 */
	private String errorDesc = null;

	/** 附加信息 */
	private LogInfo subInfo = null;

	public BaseException() {
		super();
	}

	public BaseException(String errorCode) {
		this(errorCode, null, null, null);
	}
	
	public BaseException(String errorCode, String errorDesc) {
		this(errorCode, errorDesc, null, null);
	}

	public BaseException(String errorCode, LogInfo subInfo) {
		this(errorCode, null, subInfo, null);
	}

	public BaseException(String errorCode, String errorDesc, LogInfo subInfo, Throwable cause) {
		super(subInfo == null ? null : subInfo.getInfo(), cause);
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public LogInfo getSubInfo() {
		return subInfo;
	}
}
