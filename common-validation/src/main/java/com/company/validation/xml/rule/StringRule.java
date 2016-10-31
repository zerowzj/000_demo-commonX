package com.company.validation.xml.rule;

import java.util.List;

/**
 * 字符串规则
 *
 * @author wangzhj
 */
public class StringRule extends Rule {

    /** 最小长度 */
    private int minLength = 0;
    /** 最大长度*/
    private int maxLength = 0;

    public int getMinLength() {
        return minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;


    }
}
