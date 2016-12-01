package com.company.monitor.dubbo;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        logger.info("ProviderFilter......");
        RpcContext context = RpcContext.getContext();
        String full = Joiner.on(".").join(invoker.getInterface().getCanonicalName(), invocation.getMethodName());


        Result result = null;
        try {
            invoker.invoke(invocation);
        } catch (Exception ex) {
            logger.error("");
        }

        return result;
    }
}
