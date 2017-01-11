package com.company.db.plugin;

import com.google.common.base.Stopwatch;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Sql耗时插件
 *
 * @author wangzhj
 */
@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class SqlCostPlugin extends PluginAdapter {

    private static final Logger logger = LoggerFactory.getLogger(SqlCostPlugin.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Stopwatch stopwatch = Stopwatch.createStarted();
        //
        Object[] args = invocation.getArgs();
        //
        MappedStatement mappedStatement = (MappedStatement) args[0];
        String sqlId = mappedStatement.getId();
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        mappedStatement.getParameterMap();
        mappedStatement.getResultMaps();

        logger.info("执行拦截器....");
        Object target = invocation.getTarget();
        Object result = null;
        if (target instanceof Executor) {
            Method method = invocation.getMethod();
            result = invocation.proceed();
            stopwatch.stop();
            logger.info("[SqlCostPlugin] execute [" + method.getName() + "] cost [" + (stopwatch.elapsed(TimeUnit.SECONDS)) + "] s");
        }
        return result;
    }
}
