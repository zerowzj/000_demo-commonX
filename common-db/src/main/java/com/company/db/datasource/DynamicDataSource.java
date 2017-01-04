package com.company.db.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源
 *
 * @author wangzhj
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /** 写数据源 */
    private Object writeDataSource = null;
    /** 读数据源 */
    private Object readDataSource = null;

    @Override
    public void afterPropertiesSet() {
        if (this.writeDataSource == null) {
            throw new IllegalArgumentException("writeDataSource is required");
        }
        super.setDefaultTargetDataSource(writeDataSource); //默认

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.WRITE.name(), writeDataSource);
        if(readDataSource != null) {
            targetDataSources.put(DataSourceType.READ.name(), readDataSource);
        }
        super.setTargetDataSources(targetDataSources); //

        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType dataSourceType = DataSourceHolder.get();
        String dataSource = null;
        if(dataSourceType == null || dataSourceType == dataSourceType.WRITE) {
            dataSource = dataSourceType.WRITE.name();
        } else {
            dataSource = dataSourceType.READ.name();
        }
        return dataSource;
    }


    public void setWriteDataSource(Object writeDataSource) {
        this.writeDataSource = writeDataSource;
    }

    public void setReadDataSource(Object readDataSource) {
        this.readDataSource = readDataSource;
    }
}