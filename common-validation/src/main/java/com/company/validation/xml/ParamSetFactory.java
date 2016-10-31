package com.company.validation.xml;

import java.util.Map;

/**
 * 参数集工厂
 *
 * @author wangzhj
 */
public class ParamSetFactory {

    /**
     * 获取参数集
     *
     * @param key
     * @return ParamSet
     */
    public static ParamSet getParamSet(final String key) {
        ParamSet paramSet = ParamSetParser.getParamSetMap().get(key);
        if (paramSet == null) {

        }
        return paramSet;
    }
}
