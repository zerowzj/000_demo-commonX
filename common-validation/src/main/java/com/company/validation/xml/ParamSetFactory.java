package com.company.validation.xml;

import java.util.Map;

/**
 * 参数集工厂
 *
 * @author wangzhj
 */
public class ParamSetFactory {

    private static final Map<String, ParamSet> PARAM_SET_MAP;

    static {
        PARAM_SET_MAP = ParamSetParser.getParamSetMap();
    }

    /**
     * 获取参数集
     *
     * @param key
     * @return ParamSet
     */
    public static ParamSet getParamSet(final String key) {
        ParamSet paramSet = PARAM_SET_MAP.get(key);
        if (paramSet == null) {

        }
        return paramSet;
    }
}
