package com.company.validation.xml.validator;

import com.company.exception.param.ValueIllegalException;
import com.company.validation.xml.Param;
import com.company.validation.xml.rule.DateRule;
import com.company.validation.xml.rule.NumberRule;

import java.util.Date;

/**
 * 日期规则验证器
 *
 * @author wangzhj
 */
public class DateValidator implements Validator {

    @Override
    public boolean support(Class<?> clazz) {
        return String.class.isAssignableFrom(clazz) || Date.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Param param, Object value) {
        String paramName = param.getParamName();
        DateRule rule = (DateRule) param.getRule();

        rule.getFormat();
        rule.getMinDate();
        rule.getMaxDate();
    }
}
