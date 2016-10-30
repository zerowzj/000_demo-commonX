package com.company.validation.xml.rule;

import java.util.List;

/**
 * 枚举规则
 *
 * @author wangzhj
 */
public class EnumRule extends BaseRule{

    /** 枚举值列表 */
    private List<String> valueLt = null;

    public List<String> getValueLt() {
        return valueLt;
    }

    public void setValueLt(List<String> valueLt) {
        this.valueLt = valueLt;
    }
}
