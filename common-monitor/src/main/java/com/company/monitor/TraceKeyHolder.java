package com.company.monitor;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-12-02 9:58
 */
public class TraceKeyHolder {

    private  static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static String getTraceKey() {
        return threadLocal.get();
    }

    public static void setTraceKey(String traceKey) {
        threadLocal.set(traceKey);
    }

    public static void clear() {
        threadLocal.remove();
    }

}
