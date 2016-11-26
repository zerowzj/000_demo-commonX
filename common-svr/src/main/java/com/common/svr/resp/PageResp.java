package com.common.svr.resp;

import java.io.Serializable;

/**
 * <p>分页结果</p>
 *
 * @author wangzhj
 * @time 2016-11-26 11:02
 */
public final class PageResp<T extends Serializable> extends BaseResp<T> {

    private Integer pageNo = null;

    private Integer pageSize = null;

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
