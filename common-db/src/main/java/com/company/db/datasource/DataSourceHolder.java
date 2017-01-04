package com.company.db.datasource;

/**
 * 数据源持有者
 *
 * @author wangzhj
 */
public final class DataSourceHolder {

    private static final ThreadLocal<DataSourceType> holder = new ThreadLocal<>();

    private DataSourceHolder() {
    }

    /**
     * 放入
     */
    public static void put(DataSourceType dataSource) {
        holder.set(dataSource);
    }

    /**
     * 获取
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
