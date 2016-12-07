package com.common.base.svr.resp;

import java.io.Serializable;

/**
 * <p>分页结果</p>
 *
 * @author wangzhj
 * @time 2016-11-26 11:02
 */
public final class PageResp<T extends Serializable> extends BaseResp<T> {

    /** 页码 */
    private Integer pageNo = null;
    /** 页大小 */
    private Integer pageSize = null;
    /** 总页数 */
    private Integer totalPage = null;
    /** 总条数 */
    private Integer totalCount = null;

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

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
