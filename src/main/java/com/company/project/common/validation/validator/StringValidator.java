package com.company.project.common.validation.validator;

import java.lang.annotation.Annotation;

import com.company.project.common.exception.param.FormatErrorException;
import com.company.project.common.validation.rule.StringRule;

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
				throw new FormatErrorException(paramName);
			}
			//最大长度
			int maxLength = stringRule.maxLength();
			if (length > maxLength) {
				throw new FormatErrorException(paramName);
			}
		}

	}
}
