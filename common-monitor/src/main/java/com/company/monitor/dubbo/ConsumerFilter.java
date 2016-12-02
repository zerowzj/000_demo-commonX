package com.company.monitor.dubbo;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.company.util.JsonUtil;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-30 18:55
 */
//@Activate(group = {Constants.CONSUMER}, order = -11000)
public class ConsumerFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        logger.info("ConsumerFilter......开始");
        long start = System.currentTimeMillis();
        //接口全限定名
        String canonicalName = invoker.getInterface().getCanonicalName();
        String methodName = invocation.getMethodName();
        String fqName = Joiner.on(".").join(canonicalName, methodName);
        //
        RpcContext context = RpcContext.getContext();
        logger.info(JsonUtil.toJson(invocation.getArguments()));
        Result result = null;
        try {
            result = invoker.invoke(invocation);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            long end = System.currentTimeMillis();
            logger.info("ConsumerFilter......结束");
        }
        return result;
    }
}
