package com.study.jdk.thread.executor;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangzhj on 2017/1/20.
 */
public class MyTest {

    private static final Logger logger = LoggerFactory.getLogger(MyTest.class);
    // only two threads
    static ExecutorService exec = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
//        logger.info("starting...");
//        for(int index = 0; index < 100; index++) {
//            Runnable run = new Runnable() {
//                public void run() {
//                    long time = (long) (Math.random() * 1000);
//                    logger.info("Sleeping " + time + "ms");
//                    try {
//                        Thread.sleep(time);
//                    } catch (InterruptedException e) {
//                    }
//                }
//            };
//            exec.execute(run);
//        }
//        // must shutdown
//        exec.shutdown();
//        logger.info("ending");

        System.out.println(Lists.newArrayList() == Lists.newArrayList());
    }
}
