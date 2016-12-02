package com.study.guava.string;

import com.google.common.base.Strings;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-29 16:56
 */
public class StringsTest {

    @Test
    public void test(){
        System.out.println(Strings.nullToEmpty(null));
        System.out.println(Strings.nullToEmpty("123"));

        System.out.println(Strings.emptyToNull(null));
        System.out.println(Strings.emptyToNull(""));

        System.out.println(Strings.isNullOrEmpty(null));
        System.out.println(Strings.isNullOrEmpty("  "));

        BigDecimal b1 = new BigDecimal("1");
        BigDecimal b2 = new BigDecimal("3");

        System.out.println(b1.divide(b2, 3, BigDecimal.ROUND_HALF_EVEN).movePointRight(2));

    }
}
