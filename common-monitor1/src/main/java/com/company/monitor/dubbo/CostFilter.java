package com.company.monitor.dubbo;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-30 18:55
 */
@Activate(group = {com.alibaba.dubbo.common.Constants.PROVIDER, com.alibaba.dubbo.common.Constants.CONSUMER})
public class CostFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        return null;
    }
}
