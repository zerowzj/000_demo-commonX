package com.company.common.exception.param;

import com.company.common.exception.ParamException;

/**
 * 参数格式错误异常
 * 
 * @author wangzhj
 */
public class ForamtErrorException extends ParamException {

	public ForamtErrorException(String paramName) {
		super(paramName, "1002", "参数格式错误");
	}
}
