package com.study.guava.string;

import com.google.common.base.Strings;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-29 16:56
 */
public class StringsTest {

    private static final Logger logger = LoggerFactory.getLogger(StringsTest.class);

    @Test
    public void test() {
        logger.info(Strings.nullToEmpty(null));
        logger.info(Strings.emptyToNull(null));
        logger.info(Strings.isNullOrEmpty(null) + "");

        String str = "12345678";
        logger.info(Strings.padStart(str, 10, '0'));
        logger.info(Strings.padEnd(str, 10, '0'));
        logger.info(Strings.repeat(str, 2));
        logger.info(Strings.commonPrefix("http://www.sohu.com", "http"));
        logger.info(Strings.commonSuffix("abc.jpg", "12321312.jpg"));
    }
}
