package com.company.util;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-24 13:10
 */
public abstract class TypeCastUtil {

    /**
     *
     *
     * @param obj
     * @return T
     */
    public static <T> T cast(Object obj, Class<T> clazz){
        if(obj == null){
            return null;
        }
        return (T) obj;
    }


    public static void main(String[] args) {
        String str = "1212";

        Long aa = TypeCastUtil.cast(str, Long.class);
    }
}
