package com.company.monitor;

/**
 * 时间
 *
 * @author wangzhj
 */
public class CostTimer {

    private static ThreadLocal<Long> start = new ThreadLocal<>();

    /**
     * 开始计时
     */
    public static void start(){
        start.set(System.currentTimeMillis());
    }

    /**
     * 获取耗时
     *
     * @return long
     */
    public static long getCost(){
        long end = System.currentTimeMillis();
        long time = end -start.get();
        return time;
    }

    /**
     * 清除
     */
    public static void clear(){
        start.remove();
    }
}
