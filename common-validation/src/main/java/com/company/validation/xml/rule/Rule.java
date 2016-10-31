package com.company.validation.xml.rule;

/**
 * 基础规则
 *
 * @author wangzhj
 */
public abstract class Rule {

    /** 非空 */
    private boolean notEmpty = false;

    public boolean isNotEmpty() {
        return notEmpty;
    }

    public void setNotEmpty(boolean notEmpty) {
        this.notEmpty = notEmpty;
    }
}
