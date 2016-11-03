package com.company.validation.annot.validator;

import java.lang.annotation.Annotation;
import java.util.Date;

/**
 * 日期验证器
 *
 * @author wangzhj
 */
public class DateValidator implements Validator {

    @Override
    public boolean support(Class<?> clazz) {
        return clazz == String.class || clazz == Date.class;
    }

    @Override
    public void validate(String paramName, Object value, Annotation annot) {
        //获取验证规则
        Date dateRule = (Date) annot;
        //获取验证值
        String str = null;
        if (value != null) {
            str = value.toString();
        }

        //时间范围验证
        if (str != null) {
//			//格式验证
//			DateRule.DTFormat df = dateRule.format();
//			if(true){
//				throw new FormatErrorException(paramName);
//			}
//			//最小时间
//			String minDateTime = dateRule.minDateTime();
//			if(true){
//				throw new IllegalValueException(paramName);
//			}
//			//最大时间
//			String maxDateTime = dateRule.maxDateTime();
//			if(true){
//				throw new IllegalValueException(paramName);
//			}
        }
    }
}
