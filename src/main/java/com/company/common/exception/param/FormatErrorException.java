package com.company.common.exception.param;

import com.company.common.exception.ParamException;

/**
 * 参数格式错误异常
 * 
 * @author wangzhj
 */
public class FormatErrorException extends ParamException {

	public FormatErrorException(String paramName) {
		super(paramName, "1002", "参数格式错误");
	}
}
