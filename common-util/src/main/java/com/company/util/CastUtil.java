package com.company.util;

/**
 * <p>类型转换 Util</p>
 *
 * @author wangzhj
 * @time 2016-11-24 13:10
 */
public abstract class CastUtil {

    /**
     * 转型
     *
     * @param obj
     * @return T
     */
    public static <T> T cast(Object obj){
        if(obj == null){
            return null;
        }
        return (T) obj;
    }
}
