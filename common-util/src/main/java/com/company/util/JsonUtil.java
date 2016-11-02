package com.company.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
            mapper.readValue(str, new TypeReference() {
            });
        } catch (Exception ex) {
            is = false;
        }
        return is;
    }

    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<>();
        data.put("2", 1);
        data.put("1", new Date());
        System.out.println(JsonUtil.toJson(data));
    }
}
