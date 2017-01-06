package com.company.db.datasource;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangzhj on 2017/1/5.
 */
public class DynamicSqlSessionTemplate extends SqlSessionTemplate {

    private static final Logger logger = LoggerFactory.getLogger(DynamicSqlSessionTemplate.class);

    private SqlSessionFactory sqlSessionFactory;

    public DynamicSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
        this.sqlSessionFactory = sqlSessionFactory;
        logger.info("创建DynamicSqlSessionTemplate");
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        sqlSessionFactory.openSession().getConfiguration().getDatabaseId();
        MappedStatement mappedStatement = getConfiguration().getMappedStatement(statement);
        return super.selectOne(statement, parameter);
    }
}
