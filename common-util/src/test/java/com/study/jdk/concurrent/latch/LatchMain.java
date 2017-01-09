package com.study.jdk.concurrent.latch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wangzhj on 2017/1/9.
 */
public class LatchMain {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
                latch.countDown();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2");
                latch.countDown();
            }
        });
        t2.start();


        try {
            latch.await();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("main");
    }
}
