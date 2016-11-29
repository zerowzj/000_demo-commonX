package com.common.svr.param;

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
        Preconditions.checkArgument(pageNo >= 1);
        Preconditions.checkNotNull(pageSize >= 1);
        this.pageNo = pageNo;
        this.pageSize = pageSize;

    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public static void main(String[] args) {
        Integer i = null;
        Preconditions.checkNotNull(i, "水电费水电费");
//        Preconditions.checkArgument(i != null && i > 0);
    }
}
