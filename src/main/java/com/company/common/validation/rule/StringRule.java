package com.company.common.validation.rule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字符串类型注解
 * 
 * @author wangzhj
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StringRule {

	/** 最小长度 */
	public int minLength() default 0;

	/** 最大长度 */
	public int maxLength() default 0;
}
