package com.company.common.validation.validator;

import java.lang.annotation.Annotation;

import com.company.common.exception.param.ForamtErrorException;
import com.company.common.validation.rule.StringRule;

/**
 * 字符串规则验证器
 * 
 * @author wangzhj
 */
public class StringValidator implements Validator {

	@Override
	public boolean suppport(Class<?> clazz) {
		return clazz == String.class;
	}

	@Override
	public void validate(String paramName, Object value, Annotation annot) {
		//获取验证规则
		StringRule stringRule = (StringRule) annot;
		//获取验证值
		String str = null;
		if (value != null) {
			str = value.toString();
		}
		//长度验证
		if (str != null) {
			int length = str.length();
			//最小长度
			int minLength = stringRule.minLength();
			if (length < minLength) {
				throw new ForamtErrorException(paramName);
			}
			//最大长度
			int maxLength = stringRule.maxLength();
			if (length > maxLength) {
				throw new ForamtErrorException(paramName);
			}
		}

	}
}
