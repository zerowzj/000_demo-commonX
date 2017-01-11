package com.company.monitor.dubbo;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.company.util.JsonUtil;
import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 消费者过滤器
 *
 * @author wangzhj
 */
@Activate(group = {Constants.CONSUMER})
public class ConsumerFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //计时
        Stopwatch stopwatch = Stopwatch.createStarted();
        //全限定名
        String canonicalName = invoker.getInterface().getCanonicalName();
        String methodName = invocation.getMethodName();
        String fqName = Joiner.on(".").join(canonicalName, methodName);
        //调用
        logger.info(" [REQUEST]===>{}", JsonUtil.toJson(invocation.getArguments()));
        Result result = null;
        try {
            result = invoker.invoke(invocation);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stopwatch.stop();
            logger.info("   [DUBBO][{}] [COST TIME][{}]ms", fqName, stopwatch.elapsed(TimeUnit.MILLISECONDS));
            logger.info("[RESPONSE]<==={}", JsonUtil.toJson(result.getValue()));
        }
        return result;
    }
}
