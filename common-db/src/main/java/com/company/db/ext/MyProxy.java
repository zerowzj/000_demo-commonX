package com.company.db.ext;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wangzhj on 2017/1/7.
 */
public class MyProxy<T> implements InvocationHandler, Serializable {

    public MyProxy(){

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
