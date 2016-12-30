package com.company.project;

import com.company.util.http.HttpGets;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangzhj on 2016/12/29.
 */
public class HttpGetsTest {

    ExecutorService exec = Executors.newFixedThreadPool(100);

    @Test
    public void test_submit() {
        long start = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(20);
        for (int i = 0; i < 100000; i++) {
            latch.countDown();
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    HttpGets.create("http://www.baidu.com").submit().get();
                }
            });
        }
        try {
            latch.await();
        } catch (Exception ex) {

        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

    @Test
    public void test_asyncSubmit() {
        long start = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(20);
        for (int i = 0; i < 100000; i++) {
            latch.countDown();
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    HttpGets.create("http://www.baidu.com").asyncSubmit().get();
                }
            });
        }
        try {
            latch.await();
        } catch (Exception ex) {

        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }
}
