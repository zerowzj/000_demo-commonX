package com.company.project;

import com.company.util.http.HttpGets;
import org.junit.Test;

/**
 * Created by wangzhj on 2016/12/29.
 */
public class HttpGetsTest {

    @Test
    public void test() {
        for(int i = 0; i < 100; i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpGets.create("http://www.baidu.com").submit();
                }
            });
            t.start();
        }
    }
}
