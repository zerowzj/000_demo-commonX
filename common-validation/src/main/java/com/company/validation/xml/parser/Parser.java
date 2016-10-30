package com.company.validation.xml.parser;

import com.company.validation.xml.Param;
import com.company.validation.xml.rule.Rule;
import org.dom4j.Element;

/**
 * 元素解析器
 *
 * @author wangzhj
 */
public interface Parser {

    /**
     * 解析
     *
     * @param ele
     */
    public Rule parse(Element ele);
}
