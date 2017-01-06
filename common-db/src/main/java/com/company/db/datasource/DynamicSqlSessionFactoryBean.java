package com.company.db.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

import java.io.IOException;

/**
 * Created by wangzhj on 2017/1/5.
 */
public class DynamicSqlSessionFactoryBean extends SqlSessionFactoryBean {

    private static final Logger logger = LoggerFactory.getLogger(DynamicSqlSessionFactoryBean.class);

    @Override
    protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
        SqlSessionFactory slq = super.buildSqlSessionFactory();
        return super.buildSqlSessionFactory();
    }

    @Override
    public SqlSessionFactory getObject() throws Exception {
        DataSourceHolder.put(DataSourceType.WRITE);
        logger.info("我是SqlSessionFactoryBean");
        return super.getObject();
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        super.onApplicationEvent(event);
    }
}
