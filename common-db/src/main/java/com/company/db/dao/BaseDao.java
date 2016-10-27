package com.company.db.dao;

import java.io.Serializable;

/**
 * 基础Dao
 *
 * @author wangzhj
 */
public interface BaseDao<E extends BaseEO> {

    /**
     * 新增实体
     *
     * @param entity 实体信息
     * @return int 新增数量
     */
    public E insert(E entity);

    /**
     * 删除实体
     *
     * @param id 主键
     * @return int 删除数量
     */
    public int delete(Serializable id);

    /**
     * 更新实体
     *
     * @param entity 实体信息
     * @return int 更新数量
     */
    public int update(E entity);

    /**
     * 获取实体
     *
     * @param id 主键
     * @return E 实体信息
     */
    public E get(Serializable id);
}
