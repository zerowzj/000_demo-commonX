package com.common.base.svr.param;

import com.google.common.base.Preconditions;

/**
 * <p>分页参数</p>
 *
 * @author wangzhj
 * @time 2016-11-26 11:28
 */
public class PageParam extends BaseParam {

    /** 页码 */
    private Integer pageNo = null;
    /** 页大小 */
    private Integer pageSize = null;

    public PageParam(Integer pageNo, Integer pageSize) {
        Preconditions.checkArgument(pageNo != null && pageNo >= 1, "页码[%s]必须大于0", pageNo);
        Preconditions.checkArgument(pageSize != null && pageSize >= 1, "页大小[%s]必须大于0", pageSize);
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }
}
