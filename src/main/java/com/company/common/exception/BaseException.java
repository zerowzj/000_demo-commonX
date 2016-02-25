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
	
	/** 附加信息 */
	private LogInfo subInfo = null;

	public BaseException() {
		super();
	}

	public BaseException(String errorCode) {
		this(errorCode, null, null);
	}

	public BaseException(String errorCode, LogInfo subInfo) {
		this(errorCode, subInfo, null);
	}

	public BaseException(String errorCode, LogInfo subInfo, Throwable cause) {
		super(subInfo.getInfo(), cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public LogInfo getSubInfo() {
		return subInfo;
	}
}
