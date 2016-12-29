package com.company.project;

import com.company.util.http.HttpGets;
import org.junit.Test;

/**
 * Created by wangzhj on 2016/12/29.
 */
public class HttpGetsTest {

    @Test
    public void test_submit() {
        for (int i = 0; i < 100; i++) {
            HttpGets.create("http://www.baidu.com").submit();
        }
    }

    @Test
    public void test_asyncSubmit() {
        for (int i = 0; i < 100; i++) {
            HttpGets.create("http://www.baidu.com").asyncSubmit();
        }
    }
}
