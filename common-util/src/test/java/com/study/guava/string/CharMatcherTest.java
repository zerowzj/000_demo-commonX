package com.study.guava.string;

import com.google.common.base.CharMatcher;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-29 16:10
 */
public class CharMatcherTest {

    private static final Logger logger = LoggerFactory.getLogger(CharMatcherTest.class);

    @Test
    public void test() {

        String digit = "abc123";
        logger.info(CharMatcher.digit().matchesAllOf(digit)+"");
        logger.info(CharMatcher.digit().matchesAnyOf(digit)+"");

    }
}
