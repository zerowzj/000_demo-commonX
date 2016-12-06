package com.company.monitor;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 时间
 *
 * @author wangzhj
 */
public class CostTimer {

    private static final Logger logger = LoggerFactory.getLogger(CostTimer.class);

    private static ThreadLocal<Map<String, Long>> startThreadLocal = new ThreadLocal<Map<String, Long>>() {
        @Override
        protected Map<String, Long> initialValue() {
            return Maps.newHashMap();
        }
    };

    /**
     * 开始计时
     *
     * @param key
     */
    public static void start(String key) {
        startThreadLocal.get().put(key, System.currentTimeMillis());
    }

    /**
     * 获取耗时
     *
     * @param key
     * @return long
     */
    public static long get(String key) {
        long end = System.currentTimeMillis();
        long time = end - startThreadLocal.get().get(key);
        return time;
    }

    /**
     * 清除计时器
     *
     * @param key
     */
    public static void clear(String key) {
        startThreadLocal.get().remove(key);
        if(startThreadLocal.get().isEmpty()){
            startThreadLocal.remove();
            startThreadLocal = null;
        }
    }
}
