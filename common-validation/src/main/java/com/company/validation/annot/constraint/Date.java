package com.company.validation.annot.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日期规则
 * 
 * @author wangzhj
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Date {

	/** 时间格式 */
	public DTFormat format() default DTFormat.yyyy_MM_dd_hh_mm_ss;

	/** 最小时间 */
	public String minDateTime() default "";

	/** 最大时间 */
	public String maxDateTime()  default "";

	public enum DTFormat {

		yyyy_MM_dd("yyyy-MM-dd"), yyyy_MM_dd_hh_mm_ss("yyyy-MM-dd-hh-mm-ss");

		private String value = null;

		private DTFormat(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
}
