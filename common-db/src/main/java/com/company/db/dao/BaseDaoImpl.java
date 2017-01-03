package com.company.db.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * 基础Dao实现
 *
 * @author wangzhj
 */
public abstract class BaseDaoImpl<E extends BaseEO> extends SqlSessionDaoSupport implements BaseDao<E> {

    @Override
    public final E insert(final E entity) {
        String sqlId = getSqlId("insert");
        int count = getSqlSession().insert(sqlId, entity);
        return entity;
    }

    @Override
    public final int delete(final Serializable id) {
        String sqlId = getSqlId("delete");
        int count = getSqlSession().delete(sqlId, id);
        return count;
    }

    @Override
    public final int update(final E entity) {
        String sqlId = getSqlId("update");
        int count = getSqlSession().update(sqlId, entity);
        return count;
    }

    @Override
    public final E get(final Serializable id) {
        String sqlId = getSqlId("get");
        E entity = getSqlSession().selectOne(sqlId, id);
        return entity;
    }

    /**
     * 获取sqlId
     *
     * @param sqlId
     * @return String
     */
    protected final String getSqlId(String sqlId) {
        return this.getClass().getPackage().getName() + "." + sqlId;
    }

    @Override
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
