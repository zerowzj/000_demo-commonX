package com.company.validation.annot.validator;

import com.company.exception.param.ValueIllegalException;
import com.company.validation.annot.constraint.EnumRule;

import java.lang.annotation.Annotation;
import java.security.MessageDigest;
import java.text.MessageFormat;


/**
 * 字符串规则验证器
 *
 * @author wangzhj
 */
public class EnumValidator implements Validator {

    @Override
    public boolean support(Class<?> clazz) {
        return String.class.isAssignableFrom(clazz) || Number.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(String paramName, Object value, Annotation rule) {
        //获取验证规则
        EnumRule enumRule = (EnumRule) rule;
        //获取验证值
        String str = null;
        String[] values = enumRule.values();
        if (value != null) {
            String pattern = "";
            throw new ValueIllegalException(paramName, MessageFormat.format(pattern, paramName, value));
        }
    }
}
