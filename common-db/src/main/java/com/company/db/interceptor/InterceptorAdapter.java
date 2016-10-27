package com.company.db.interceptor;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Plugin;

import java.util.Properties;

/**
 * 拦截器适配器
 *
 * @author wangzhj
 */
public abstract class InterceptorAdapter implements Interceptor {

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
