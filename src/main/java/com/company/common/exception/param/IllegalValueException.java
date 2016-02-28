package com.company.common.exception.param;

import com.company.common.exception.ParamException;

/**
 * 参数值非法异常
 * 
 * @author wangzhj
 */
public class IllegalValueException extends ParamException {

	public IllegalValueException(String paramName) {
		super(paramName, "1003", "参数值非法");
	}
}
