package com.company.validation.validator;

import com.company.validation.annotation.EnumRule;

import java.lang.annotation.Annotation;


/**
 * 字符串规则验证器
 * 
 * @author wangzhj
 */
public class EnumValidator implements Validator {

	@Override
	public boolean suppport(Class<?> clazz) {
		return clazz == String.class;
	}

	@Override
	public void validate(String paramName, Object value, Annotation annot) {
		//获取验证规则
		EnumRule enumRule = (EnumRule) annot;
		//获取验证值
		String str = null;
		if (value != null) {
			str = value.toString();
		}
	}
	
	public static void main(String[] args) {
		int a =1;
		Integer b = 1;
		System.out.println(b.getClass());
		
		System.out.println(int.class == Integer.TYPE);
		System.out.println(b.getClass() == Integer.TYPE);
	}
}
