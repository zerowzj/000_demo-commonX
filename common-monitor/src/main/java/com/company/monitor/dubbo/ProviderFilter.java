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
        //设置
        String callTraceKey = RpcContext.getContext().getAttachment(Constant.CALL_TRACE_KEY);
        MDC.put("id", callTraceKey);
        //计时
        CostTimer.start(Constant.PROVIDER_COST_TIMER);
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
            logger.info("[RESPONSE]<==={}", JsonUtil.toJson(result.getValue()));
            //清理
            CostTimer.clear(Constant.PROVIDER_COST_TIMER);
            MDC.clear();
        }
        return result;
    }
}
