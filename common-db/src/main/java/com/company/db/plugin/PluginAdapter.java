package com.company.db.plugin;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Plugin;

import java.util.Properties;

/**
 * 插件适配器
 *
 * @author wangzhj
 */
public abstract class PluginAdapter implements Interceptor {

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
