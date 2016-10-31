package com.company.validation.xml.validator;

import com.company.exception.domain.param.FormatErrorException;
import com.company.validation.xml.Param;
import com.company.validation.xml.rule.StringRule;

/**
 * Created by wangzhj on 2016/10/30.
 */
public class StringValidator implements Validator {

    @Override
    public boolean support(Object obj) {
        return obj instanceof String;
    }

    @Override
    public void validate(Param param, Object value) {
        String paramName = param.getParamName();
        int length = value.toString().length();
        StringRule rule = (StringRule) param.getRule();
        int minLength = rule.getMinLength();
        if (minLength > 0 && length < minLength) {
            throw new FormatErrorException(paramName, value);
        }

        int maxLength = rule.getMaxLength();
        if (maxLength > 0 && length > maxLength) {
            throw new FormatErrorException(paramName, value);
        }
    }
}
