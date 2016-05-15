package com.company.project.common.exception;

import com.company.project.common.log.LogInfo;

/**
 * 基础异常
 *
 * @author wangzhj
 */
public abstract class BaseException extends RuntimeException {

    /** 错误码 */
    private String errorCode = null;

    /** 错误描述 */
    private String errorDesc = null;

    /** 附加信息 */
    private LogInfo subInfo = null;

    public BaseException() {
        super();
    }

    public BaseException(String errorDesc) {
        this(null, errorDesc);
    }

    public BaseException(String errorCode, String errorDesc) {
        this(errorCode, errorDesc, null, null);
    }

    public BaseException(String errorDesc, LogInfo subInfo) {
        this(null, errorDesc, subInfo, null);
    }

    public BaseException(String errorCode, String errorDesc, LogInfo subInfo, Throwable cause) {
        super(subInfo.getInfo(), cause);
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.subInfo = subInfo;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public LogInfo getSubInfo() {
        return subInfo;
    }
}
