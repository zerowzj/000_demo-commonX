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

/**
 * 消费者过滤器
 *
 * @author wangzhj
 * @time 2016-11-30 18:55
 */
@Activate(group = {Constants.CONSUMER})
public class ConsumerFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //计时
        CostTimer.start(Constant.COST_TIMER_CONSUMER);
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
            logger.info("   [DUBBO][{}] [COST TIME][{}]ms", fqName, CostTimer.get(Constant.COST_TIMER_CONSUMER));
            logger.info("[RESPONSE]<==={}", JsonUtil.toJson(result.getValue()));
            //清理
            CostTimer.clear(Constant.COST_TIMER_CONSUMER);
        }
        return result;
    }
}
