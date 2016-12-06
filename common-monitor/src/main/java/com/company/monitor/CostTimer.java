package com.company.monitor;

/**
 * 时间
 *
 * @author wangzhj
 */
public class CostTimer {

    private static ThreadLocal<Long> startThreadLocal = new ThreadLocal<>();

    /**
     * 开始计时
     */
    public static void start(){
        startThreadLocal.set(System.currentTimeMillis());
    }

    /**
     * 获取耗时
     *
     * @return long
     */
    public static long get(){
        long end = System.currentTimeMillis();
        long time = end - startThreadLocal.get();
        return time;
    }

    /**
     * 清除
     */
    public static void clear(){
        startThreadLocal.remove();
    }
}
