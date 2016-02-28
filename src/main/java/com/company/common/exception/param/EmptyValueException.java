package com.company.common.exception.param;

import com.company.common.exception.ParamException;

/**
 * 参数为空异常
 * 
 * @author wangzhj
 */
public class EmptyValueException extends ParamException {

	public EmptyValueException(String paramName) {
		super(paramName, "1001", "参数值为空");
	}	
}
