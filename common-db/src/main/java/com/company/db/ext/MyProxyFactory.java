package com.company.db.ext;

import org.apache.ibatis.binding.MapperProxy;

import java.lang.reflect.Proxy;

/**
 * Created by wangzhj on 2017/1/7.
 */
public class MyProxyFactory<T> {

    protected T newInstance(MyProxy<T> proxy) {
//        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    return null;
    }
}
