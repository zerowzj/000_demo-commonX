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
    public void test() {

        ParamSet paramSet = new ParamSetFactory().getParamSet("/login");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", "11");
        paramMap.put("type", 100);
        try {
            ValidateUtil.validate(paramMap, paramSet);
        } catch (ParamException ex) {
            System.out.println(ExceptionUtil.getErrorDesc(ex));
            System.out.println(ExceptionUtil.getErrorDetail(ex));
        }
    }
}
