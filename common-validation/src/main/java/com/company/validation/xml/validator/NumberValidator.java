package com.company.validation.xml.validator;

import com.company.exception.param.ValueIllegalException;
import com.company.validation.xml.Param;
import com.company.validation.xml.rule.NumberRule;

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
        StringBuffer detail = new StringBuffer("[" + paramName + "]");
        //最小值
        String minValue = rule.getMinValue();
        if (minValue != null && myValue < Double.parseDouble(minValue)) {
            detail.append("值小于").append("["+minValue+"]");
            throw new ValueIllegalException(detail.toString(), paramName, value);
        }
        //最大值
        String maxValue = rule.getMaxValue();
        if (maxValue != null && myValue > Double.parseDouble(maxValue)) {
            detail.append("值大于").append("["+minValue+"]");
            throw new ValueIllegalException(detail.toString(), paramName, value);
        }
    }
}
