package com.company.util.match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangzhj on 2017/1/17.
 */
public class RegExPatternMatcher implements PatternMatcher {

    @Override
    public boolean matches(String pattern, String source) {
        if (pattern == null) {
            throw new IllegalArgumentException("pattern argument cannot be null.");
        }
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        return m.matches();
    }
}
