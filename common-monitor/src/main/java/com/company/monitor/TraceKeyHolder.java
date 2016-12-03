package com.company.monitor;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-12-02 9:58
 */
public class TraceKeyHolder {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    /**
     * 获取TraceKey
     */
    public static String getTraceKey() {
        return threadLocal.get();
    }

    /**
     * 设置TraceKey
     */
    public static void setTraceKey(String traceKey) {
        threadLocal.set(traceKey);
    }

    /**
     * 清除TraceKey
     */
    public static void clear() {
        threadLocal.remove();
    }
}
