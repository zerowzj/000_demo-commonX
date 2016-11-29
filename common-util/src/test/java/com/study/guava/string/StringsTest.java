package com.study.guava.string;

import com.google.common.base.Strings;
import org.junit.Test;

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

    }
}
