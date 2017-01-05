package com.company.db.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据源持有者
 *
 * @author wangzhj
 */
public final class DataSourceHolder {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceHolder.class);

    private static final ThreadLocal<DataSourceType> holder = new ThreadLocal<>();

    private DataSourceHolder() {
    }

    /**
     * 设置数据源类型
     */
    public static void put(DataSourceType dataSource) {
        holder.set(dataSource);
    }

    /**
     * 获取数据源类型
     *
     * @return DataSourceType
     */
    public static DataSourceType get() {
        return holder.get();
    }

    /**
     * 清除
     */
    public static void clear() {
        holder.remove();
    }
}
