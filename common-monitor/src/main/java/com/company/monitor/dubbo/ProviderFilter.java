package com.company.monitor.dubbo;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.company.monitor.Constant;
import com.company.util.JsonUtil;
import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.concurrent.TimeUnit;

/**
 * 生产者过滤器
 *
 * @author wangzhj
 */
@Activate(group = {Constants.PROVIDER})
public class ProviderFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ProviderFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //设置
        String callTraceKey = RpcContext.getContext().getAttachment(Constant.CALL_TRACE_KEY);
        MDC.put("id", callTraceKey);
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
            //清理
            MDC.clear();
        }
        return result;
    }
}
