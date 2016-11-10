package com.company.validation.xml.validator;

import com.company.exception.param.LengthException;
import com.company.validation.xml.Param;
import com.company.validation.xml.rule.StringRule;

/**
 * 字符串规则验证器
 *
 * @author wangzhj
 */
public class StringValidator implements Validator {

    @Override
    public boolean support(Class<?> clazz) {
        return String.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Param param, Object value) {
        String paramName = param.getParamName();
        int length = value.toString().length();
        StringRule rule = (StringRule) param.getRule();
        //长度
        int minLength = rule.getMinLength();
        int maxLength = rule.getMaxLength();
        if ((minLength > 0 && length < minLength) || (maxLength > 0 && length > maxLength)) {
            throw new LengthException(paramName);
        }
    }
}
