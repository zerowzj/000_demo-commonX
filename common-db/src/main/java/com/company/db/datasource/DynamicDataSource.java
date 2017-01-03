package com.company.db.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhj on 2017/1/3.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private Object writeDataSource = null;

    private Object readDataSource = null;

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType dataSourceType = DataSourceHolder.get();

        if(dataSourceType == null || dataSourceType == dataSourceType.WRITE) {
            return dataSourceType.WRITE.name();
        }

        return dataSourceType.READ.name();
    }

    @Override
    public void afterPropertiesSet() {
        if (this.writeDataSource == null) {
            throw new IllegalArgumentException("Property 'writeDataSource' is required");
        }
        setDefaultTargetDataSource(writeDataSource);
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.WRITE.name(), writeDataSource);
        if(readDataSource != null) {
            targetDataSources.put(DataSourceType.READ.name(), readDataSource);
        }
        setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }
}
