package com.company.db.datasource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 数据源决定者
 *
 * @author wangzhj
 */
public abstract class DataSourceDecider implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceDecider.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = null;
        try {
            decide(invocation.getThis(), invocation.getMethod(), invocation.getArguments());
            result = invocation.proceed();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public abstract void decide(Object target, Method method, Object[] args);
}
