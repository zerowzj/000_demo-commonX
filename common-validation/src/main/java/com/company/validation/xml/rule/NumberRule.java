package com.company.validation.xml.rule;

/**
 * 数字规则
 *
 * @author wangzhj
 */
public class NumberRule extends Rule {

    /** 精度 */
    private int precision = 0;

    /** 最小值 */
    private String minValue = null;
    /** 最大值 */
    private String maxValue = null;

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }
}
