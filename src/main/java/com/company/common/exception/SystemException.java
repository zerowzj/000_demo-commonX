package com.company.common.exception;

import com.company.common.log.LogInfo;

/**
 * 系统异常
 * 
 * @author wangzhj
 */
public class SystemException extends BaseException {

	public SystemException(LogInfo subInfo) {
		this("9999", subInfo, null);
	}
	
	public SystemException(String errorCode, LogInfo subInfo) {
		this(errorCode, subInfo, null);
	}
	
	public SystemException(String errorCode, LogInfo subInfo, Throwable cause) {
		super(errorCode, null, subInfo, cause);
	}
}
