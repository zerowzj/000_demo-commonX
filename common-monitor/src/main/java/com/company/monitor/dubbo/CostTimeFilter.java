package com.company.monitor.dubbo;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.company.monitor.Constant;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * <p>耗时过滤器</p>
 *
 * @author wangzhj
 * @time 2016-11-30 18:55
 */
@Activate(group = {Constants.CONSUMER, Constants.PROVIDER})
public class CostTimeFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(CostTimeFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //上下文
        RpcContext context = RpcContext.getContext();
        //服务端
        boolean isProvider = context.isProviderSide();
        String callTraceKey = context.getAttachment(Constant.CALL_TRACE_KEY);
        if (isProvider) {
            MDC.put("id", callTraceKey);
        }
        logger.info("CostTimeFilter......");
        long start = System.currentTimeMillis();
        //接口全限定名
        String canonicalName = invoker.getInterface().getCanonicalName();
        String methodName = invocation.getMethodName();
        String fqName = Joiner.on(".").join(canonicalName, methodName);
        //调用
        Result result = null;
        try {
            result = invoker.invoke(invocation);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            long end = System.currentTimeMillis();
            logger.info("Dubbo Interface[{}] [COST TIME] [{}] s", fqName, (end - start) / 1000.00D);
            //对于涉及到ThreadLocal相关使用的接口，
            //都需要去考虑在使用完上下文对象时，
            //清除掉对应的数据，以避免内存泄露问题
            MDC.clear();
        }
        return result;
    }
}
