package com.company.validation.xml.validator;

import com.company.validation.xml.Param;

/**
 * Created by wangzhj on 2016/10/30.
 */
public class EnumValidator extends BaseValidator{

    @Override
    public boolean support(Object obj) {
        return obj instanceof String || obj instanceof Number;
    }

    @Override
    public void validateCustom(Param param, Object value) {


    }

    public static void main(String[] args) {
        short s1 = 1;
        Short s2 = 1;
        int i1 = 1;
        Integer i2 = 1;
        long l1 = 1L;
        Long l2 = 1L;

        System.out.println(new EnumValidator().support(s1));
        System.out.println(new EnumValidator().support(s2));
        System.out.println(new EnumValidator().support(i1));
        System.out.println(new EnumValidator().support(i2));
        System.out.println(new EnumValidator().support(l1));
        System.out.println(new EnumValidator().support(l2));
    }
}
