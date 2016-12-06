package com.company.monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 时间
 *
 * @author wangzhj
 */
public class CostTimer {

    private static final Logger logger = LoggerFactory.getLogger(CostTimer.class);

    private static ThreadLocal<Long> startThreadLocal = new ThreadLocal<>();

    /**
     * 开始计时
     */
    public static void start(){
        logger.info("线程 {} start", Thread.currentThread().getName());
        startThreadLocal.set(System.currentTimeMillis());
    }

    /**
     * 获取耗时
     *
     * @return long
     */
    public static long get(){
        logger.info("线程 {} get", Thread.currentThread().getName());
        long end = System.currentTimeMillis();
        long time = end - startThreadLocal.get();
        return time;
    }

    /**
     * 清除
     */
    public static void clear(){
        logger.info("线程 {} clear", Thread.currentThread().getName());
        startThreadLocal.remove();
    }
}
