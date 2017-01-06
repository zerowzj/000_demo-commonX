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
public class DynamicDataSourceDecideInterceptor implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceDecideInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = null;
        try {
            Class<?> clazz = invocation.getThis().getClass();
            String name = invocation.getMethod().getName();
            Object[] args = invocation.getArguments();
            if (args != null && args.length >= 1) {
                Object lastArg = args[args.length - 1];
                if (lastArg instanceof Boolean) {
                    Boolean f = (Boolean) lastArg;
                    if (f) {
                        DataSourceHolder.put(DataSourceType.WRITE);
                        logger.info("===>对方法[{}]设置数据源[{}]", clazz.getName() + "." + name, "WRITE");
                    }
                }
            }
            result = invocation.proceed();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
