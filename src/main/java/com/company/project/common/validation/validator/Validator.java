package com.company.project.common.validation.validator;

import java.lang.annotation.Annotation;

/**
 * 验证器
 * 
 * @author wangzhj
 */
public interface Validator {
	
	/**
	 * 支持类型
	 * 
	 * @param clazz
	 * @return boolean
	 */
	public boolean suppport(Class<?> clazz);

	/**
	 * 验证
	 * 
	 * @param paramName
	 * @param annot
	 * @param value
	 */
	public void validate(String paramName, Object value, Annotation annot);
}
