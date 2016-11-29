package com.common.svr.util;

import com.common.svr.resp.BaseResp;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-26 16:36
 */
public abstract class RespUtil {

    public static <T extends Serializable> BaseResp success(T data) {
        BaseResp<T> resp = new BaseResp<>();
        resp.setCode("");
        resp.setDesc("");
        resp.setData(data);
        return resp;
    }

    public static BaseResp fail(String code, String desc) {
        BaseResp resp = new BaseResp();
        resp.setCode(code);
        resp.setDesc(desc);
        return resp;
    }
}
