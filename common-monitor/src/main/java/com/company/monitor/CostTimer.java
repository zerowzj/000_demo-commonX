package com.company.monitor;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 耗时计时器
 * 对于涉及到ThreadLocal相关使用的接口，都需要去考虑在使用完上下文对象时，清除掉对应的数据，以避免内存泄露问题
 *
 * @author wangzhj
 */
public class CostTimer {

    private static final Logger logger = LoggerFactory.getLogger(CostTimer.class);

    private static ThreadLocal<Map<String, Long>> startThreadLocal = new ThreadLocal<Map<String, Long>>() {
        @Override
        protected Map<String, Long> initialValue() {
            logger.info("initialValue");
            return new HashMap<>();
        }
    };

    /**
     * 开始计时
     *
     * @param key
     */
    public static void start(String key) {
        logger.info("start");
        startThreadLocal.get().put(key, System.currentTimeMillis());
    }

    /**
     * 获取耗时
     *
     * @param key
     * @return long
     */
    public static long get(String key) {
        logger.info("get");
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
        logger.info("clear");
        startThreadLocal.get().remove(key);
        if(startThreadLocal.get().isEmpty()){
            startThreadLocal.remove();
        }
    }
}
