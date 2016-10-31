package com.company.validation.xml;

import com.company.validation.xml.rule.Rule;

import java.util.List;

/**
 * 参数
 *
 * @author wangzhj
 */
public class Param {

    /** 参数名 */
    private String paramName = null;
    /** 是否非空 */
    private boolean notEmpty = false;
    /** 规则 */
    private Rule rule = null;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }
}
