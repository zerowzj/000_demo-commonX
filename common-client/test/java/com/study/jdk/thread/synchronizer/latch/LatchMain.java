package com.study.jdk.thread.synchronizer.latch;

import com.google.common.base.Stopwatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch类有3个基本元素：
 * （1）初始值决定CountDownLatch类需要等待的事件的数量。
 * （2）await() 方法, 被等待全部事件终结的线程调用。
 * （3）countDown() 方法，事件在结束执行后调用。
 * CountDownLatch 机制不是用来保护共享资源或者临界区。它是用来同步一个或者多个执行多个任务的线程。
 */
public class LatchMain {

    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        final CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception ex) {

                } finally {
                    latch.countDown();
                }
            }
        });
//        latch.countDown();
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception ex) {

                } finally {
                    latch.countDown();
                }
            }
        });
//        latch.countDown();
        t2.start();


        try {
            latch.await();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("main");
        stopwatch.stop();
        System.out.println("===>"+stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }


    public static void main1(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                latch.countDown();
                System.out.println("2");
                latch.countDown();
            }
        });
        t.start();

        try {
            latch.await();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("3");
    }
}
