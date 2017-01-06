package com.company.db.datasource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据源决定者
 *
 * @author wangzhj
 */
public class DynamicDataSourceDecider implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceDecider.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Class<?> clazz = invocation.getThis().getClass();
        String name = invocation.getMethod().getName();
        Object[] args = invocation.getArguments();
        DataSourceHolder.put(DataSourceType.WRITE);
        logger.info("===>对方法[{}]设置数据源[{}]", clazz.getName() + "."+name, "WRITE");
        Object result = null;
        try {
            result = invocation.proceed();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
