package com.common.svr.resp;

import java.io.Serializable;

/**
 * <p>基本结果</p>
 *
 * @author wangzhj
 * @time 2016-11-26 10:57
 */
public class BaseResp<T extends Serializable> implements Serializable{

    /** 结果码 */
    private String code = null;
    /** 结果描述 */
    private String desc = null;
    /** 结果数据 */
    private T data = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
