package com.company.common.exception;

/**
 * 参数异常
 * 
 * @author wangzhj
 */
public class ParamException extends BaseException {

	/** 参数名 */
	private String paramName = null;

	public ParamException(String paramName, String errorCode) {
		super(errorCode);
		this.paramName = paramName;
	}

	public String getParamName() {
		return paramName;
	}
}
