package com.company.validation.xml.rule;

/**
 * 时间规则
 *
 * @author wangzhj
 */
public class DateRule extends Rule {

    /** 日期格式 */
    private String format = null;
    /** 最小日期 */
    private String minDate = null;
    /** 最大日期 */
    private String maxDate = null;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMinDate() {
        return minDate;
    }

    public void setMinDate(String minDate) {
        this.minDate = minDate;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }
}
