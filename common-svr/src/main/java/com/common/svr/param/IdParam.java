package com.common.svr.param;

import com.google.common.base.Preconditions;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-29 11:12
 */
public class IdParam extends BaseParam {

    /**  */
    private Long id = null;

    public IdParam(Long id){
        Preconditions.checkNotNull(id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
