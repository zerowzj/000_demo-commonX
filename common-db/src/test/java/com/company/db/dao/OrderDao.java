package com.company.db.dao;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-25 18:17
 */
public interface OrderDao extends BaseDao<OrderEO> {

    public OrderEO findLt(Long id);
}
