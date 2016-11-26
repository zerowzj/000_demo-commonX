package com.common.svr.resp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-26 11:02
 */
public final class PageResp<T extends Serializable> extends ArrayList<T> {

    /** 结果码 */
    private String code = null;
    /** 结果描述 */
    private String desc = null;

    private Integer pageNo = null;

    private Integer pageSize = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
