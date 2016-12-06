package com.company.monitor.dubbo;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.company.monitor.Constant;
import com.company.monitor.CostTimer;
import com.company.util.JsonUtil;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-30 18:55
 */
@Activate(group = {Constants.PROVIDER})
public class ProviderFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ProviderFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        CostTimer.start(Constant.PROVIDER_COST_TIMER);
        //上下文
        RpcContext context = RpcContext.getContext();
        //设置
        String callTraceKey = context.getAttachment(Constant.CALL_TRACE_KEY);
         MDC.put("id", callTraceKey);
        //全限定名
        String canonicalName = invoker.getInterface().getCanonicalName();
        String methodName = invocation.getMethodName();
        String fqName = Joiner.on(".").join(canonicalName, methodName);
        //调用
        logger.info("[REQUEST]===>{}", JsonUtil.toJson(invocation.getArguments()));
        Result result = null;
        try {
            result = invoker.invoke(invocation);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            logger.info("[DUBBO][{}] [COST TIME][{}]ms", fqName, CostTimer.get(Constant.PROVIDER_COST_TIMER));
            //对于涉及到ThreadLocal相关使用的接口，
            //都需要去考虑在使用完上下文对象时，
            //清除掉对应的数据，以避免内存泄露问题
            logger.info("[RESPONSE]<==={}", JsonUtil.toJson(result.getValue()));
            MDC.clear();
            CostTimer.clear(Constant.PROVIDER_COST_TIMER);
        }
        return result;
    }
}
