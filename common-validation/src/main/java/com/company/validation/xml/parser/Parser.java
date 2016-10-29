package com.company.validation.xml.parser;

import com.company.validation.xml.Param;
import org.dom4j.Element;

/**
 * 元素解析器
 *
 * @author wangzhj
 */
public interface Parser {

    /**
     * 解析类型
     *
     * @param ele
     * @param param
     */
    public void parse(final Element ele, final Param param);
}
