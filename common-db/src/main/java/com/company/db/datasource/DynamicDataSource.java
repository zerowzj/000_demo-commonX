package com.company.db.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 *
 * @author wangzhj
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType dataSourceType = DataSourceHolder.get();
        String dataSource = null;
        if (dataSourceType == null || dataSourceType == dataSourceType.WRITE) {
            dataSource = dataSourceType.WRITE.name();
        } else {
            dataSource = dataSourceType.READ.name();
        }
        logger.info("===>使用[{}]数据源", dataSourceType);
        return dataSource;
    }
}
