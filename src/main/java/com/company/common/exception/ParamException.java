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

	public ParamException(String paramName, String errorCode, String errorDesc) {
		super(errorCode, errorDesc);
		this.paramName = paramName;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" ").append(this.paramName).append(" ")
				.append(getErrorDesc()).append("[").append(getErrorCode())
				.append("]");
		return sb.toString();
	}

	public String getParamName() {
		return paramName;
	}
}
