package com.company.validation.xml.validator;

import com.company.exception.param.ValueIllegalException;
import com.company.validation.xml.Param;
import com.company.validation.xml.rule.NumberRule;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 数字规则验证器
 *
 * @author wangzhj
 */
public class NumberValidator implements Validator {

    @Override
    public boolean support(Class<?> clazz) {
        return String.class.isAssignableFrom(clazz) || Number.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Param param, Object value) {
        String paramName = param.getParamName();
        NumberRule rule = (NumberRule) param.getRule();

        Double myValue = Double.parseDouble(value.toString());

        Double minValue = Double.parseDouble(rule.getMinValue());
        if (myValue < minValue) {
            throw new ValueIllegalException(paramName, value);
        }
        Double maxValue = Double.parseDouble(rule.getMaxValue());
        if (myValue > maxValue) {
            throw new ValueIllegalException(paramName, value);
        }
    }
}
