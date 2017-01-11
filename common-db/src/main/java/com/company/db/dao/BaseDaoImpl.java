package com.company.db.dao;

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * 基础Dao实现
 *
 * @author wangzhj
 */
public abstract class BaseDaoImpl<E extends BaseEO> implements BaseDao<E> {

    protected SqlSessionTemplate sqlSessionTemplate;

    @Override
    public final E insert(final E entity) {
        String sqlId = getSqlId("insert");
        int count = sqlSessionTemplate.insert(sqlId, entity);
        return entity;
    }

    @Override
    public final int delete(final Serializable id) {
        String sqlId = getSqlId("delete");
        int count = sqlSessionTemplate.delete(sqlId, id);
        return count;
    }

    @Override
    public final int update(final E entity) {
        String sqlId = getSqlId("update");
        int count = sqlSessionTemplate.update(sqlId, entity);
        return count;
    }

    @Override
    public final E get(final Serializable id) {
        String sqlId = getSqlId("get");
        E entity = sqlSessionTemplate.selectOne(sqlId, id);
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

    @Resource
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate){
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
