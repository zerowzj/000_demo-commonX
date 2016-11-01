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

        BigDecimal b = new BigDecimal(value.toString());

        String minValue = rule.getMinValue();
        String maxValue = rule.getMinValue();

//        if(){
//            throw new ValueIllegalException(paramName, value);
//        }
    }

    public static void main(String[] args) {
        Long l = 1L;
        Float f = 1.000F;
        Double d = 20.000D;
        System.out.println(l.toString());
        System.out.println(f);
        System.out.println(d.toString());
    }
}
