package com.company.project.common.exception;

import com.company.project.common.log.LogInfo;

/**
 * @author wangzhj
 */
public class ExceptionHandler {

    /**
     * 获取参数异常信息
     *
     * @param paramName 参数名称
     * @param errorCode 错误码
     * @param errorDesc 错误描述
     * @return LogInfo
     */
    public static LogInfo getMsgOfParamException(String paramName, String errorCode, String errorDesc) {
        LogInfo subInfo = new LogInfo();
        subInfo.append(errorDesc);
        if(paramName != null){
            subInfo.append("["+paramName+"]");
        }
        if(errorCode != null){
            subInfo.append("["+errorCode+"]");
        }
        return subInfo;
    }

    /**
     * 获取业务异常信息
     *
     * @param targetName 目标名称
     * @param errorCode 错误码
     * @param errorDesc 错误描述
     * @return LogInfo
     */
    public static LogInfo getMsgOfBusinessException(String targetName, String errorCode, String errorDesc){
        LogInfo subInfo = new LogInfo();
        if(targetName != null){
            subInfo.append("["+targetName+"]");
        }
        subInfo.append(errorDesc);
        if(errorCode != null){
            subInfo.append("["+errorCode+"]");
        }
        return subInfo;
    }

    /**
     * 获取系统异常信息
     *
     * @param errorDesc 错误描述
     * @return LogInfo
     */
    public static LogInfo getMsgOfSystemException(String errorDesc){
        LogInfo subInfo = new LogInfo();
        subInfo.append(errorDesc);
        return subInfo;
    }
}
