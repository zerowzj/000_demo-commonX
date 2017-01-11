package com.company.monitor;

import java.math.BigDecimal;

/**
 *
 * 对于涉及到ThreadLocal相关使用的接口，都需要去考虑在使用完上下文对象时，
 * 清除掉对应的数据，以避免内存泄露问题
 * @author wangzhj
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
