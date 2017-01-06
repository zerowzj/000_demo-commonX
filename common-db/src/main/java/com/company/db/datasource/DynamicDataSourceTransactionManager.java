package com.company.db.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;

/**
 * 动态数据源事务管理器
 *
 * @author wangzhj
 */
public class DynamicDataSourceTransactionManager extends DataSourceTransactionManager {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceTransactionManager.class);

    /**
     * 只读事务到读库，读写事务到写库
     *
     * @param transaction
     * @param definition
     */
    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) {
        DataSourceType dataSourceType = DataSourceHolder.get();
        if(dataSourceType == null){
            String name = definition.getName();
            //设置数据源
            boolean readOnly = definition.isReadOnly();
            if(readOnly) {
                dataSourceType = DataSourceType.READ;
            } else {
                dataSourceType = DataSourceType.WRITE;
            }
            DataSourceHolder.put(dataSourceType);
            logger.info("===>对方法[{}]设置数据源[{}]", name, dataSourceType);
        }
        //
        super.doBegin(transaction, definition);
    }

    /**
     * 清理本地线程的数据源
     *
     * @param transaction
     */
    @Override
    protected void doCleanupAfterCompletion(Object transaction) {
        super.doCleanupAfterCompletion(transaction);
        DataSourceHolder.clear();
    }
}
