package com.company.db;

import com.company.db.datasource.DataSourceDecider;

import java.lang.reflect.Method;

/**
 * Created by wangzhj on 2017/1/7.
 */
public class MyDataSourceDecider extends DataSourceDecider {

    @Override
    public void decide(Object target, Method method, Object[] args) {

    }
}
