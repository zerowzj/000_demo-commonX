package com.company.exception;

import com.company.validation.ValidateUtil;
import com.company.validation.xml.ParamSet;
import com.company.validation.xml.ParamSetFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhj on 2016/11/1.
 */
public class RuleTest {

    @Test
    public void testNotEmpty() {
        ParamSet paramSet = new ParamSetFactory().getParamSet("/login");
        Map<String, Object> paramMap = new HashMap<>();
        try {
            ValidateUtil.validate(paramMap, paramSet);
        } catch (ParamException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getErrorDesc());
            ex.printStackTrace();
        }
    }

    @Test
    public void testStringRule() {
        ParamSet paramSet = new ParamSetFactory().getParamSet("/login");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", "1");
        paramMap.put("type", 1);
        try {
            ValidateUtil.validate(paramMap, paramSet);
        } catch (ParamException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getErrorDesc());
            ex.printStackTrace();
        }
    }

    @Test
    public void testEnumRule() {
        ParamSet paramSet = new ParamSetFactory().getParamSet("/login");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", "wangzhj");
        paramMap.put("type", 1);
        try {
            ValidateUtil.validate(paramMap, paramSet);
        } catch (ParamException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getErrorDesc());
            ex.printStackTrace();
        }
    }
}
