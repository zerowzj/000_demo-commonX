package com.company.exception;

/**
 * 业务异常
 *
 * @author wangzhj
 */
public class BusinessException extends BaseException {

    /** 对象名称 */
    private String objName = null;

    public BusinessException(String errorCode, String errorDesc, String errorDetail, String objName){
        super(errorCode, errorDesc, errorDetail);
        this.objName = objName;
    }

    public String getObjName() {
        return objName;
    }
}
