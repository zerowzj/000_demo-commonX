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

    /** 规则列表 */
    private List<Rule> ruleLt = null;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public List<Rule> getRuleLt() {
        return ruleLt;
    }

    public void setRuleLt(List<Rule> ruleLt) {
        this.ruleLt = ruleLt;
    }
}
