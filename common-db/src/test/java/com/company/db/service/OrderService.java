package com.company.db.service;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-12-01 11:22
 */
public interface OrderService {

    public void add(Long id, String name);

    public void get(Long id);

    public void find(Long id);

    public void findLt(Long id, boolean f);
}
