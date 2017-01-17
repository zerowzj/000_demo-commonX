package com.company.util.match;

/**
 * Created by wangzhj on 2017/1/17.
 */
public interface PatternMatcher {

    /**
     * @param pattern
     * @param source
     * @return boolean
     */
    boolean matches(String pattern, String source);
}
