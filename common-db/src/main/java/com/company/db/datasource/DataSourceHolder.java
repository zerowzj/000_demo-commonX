package com.company.db.datasource;

/**
 * Created by wangzhj on 2017/1/3.
 */
public final class DataSourceHolder {

    private static final ThreadLocal<DataSourceType> holder = new ThreadLocal<DataSourceType>();

    private DataSourceHolder() {
    }

    public static void put(DataSourceType dataSource) {
        holder.set(dataSource);
    }

    public static DataSourceType get() {
        return holder.get();
    }

    public static void clear() {
        holder.remove();
    }
}
