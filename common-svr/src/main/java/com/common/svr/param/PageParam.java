package com.common.svr.param;

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

    public PageParam(Integer pageNo, Integer pageSize){
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
