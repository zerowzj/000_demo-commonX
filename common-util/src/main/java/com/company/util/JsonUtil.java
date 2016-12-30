package com.company.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json Util
 *
 * @author wangzhj
 */
public abstract class JsonUtil {

    /**
     * 对象转Json
     *
     * @param obj
     * @return String
     */
    public static String toJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return str;
    }

    /**
     * Json转对象
     *
     * @param str
     * @return T
     */
    public static <T> T fromJson(String str) {
        ObjectMapper mapper = new ObjectMapper();
        T t = null;
        try {
            t = mapper.readValue(str, new TypeReference<T>() {
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return t;
    }

    /**
     * 是否是Json
     *
     * @param str
     * @return boolean
     */
    public static boolean isJson(String str) {
        if (str == null) {
            return false;
        }
        boolean is = true;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.readValue(str, Object.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            is = false;
        }
        return is;
    }
}
