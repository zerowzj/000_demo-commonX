package com.company.util;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * Created by wangzhj on 2017/1/14.
 */
public class CollectionUtil {

    /**
     *
     *
     */
    public static boolean isEmpty(Collection<?> collection){
        if(collection == null || collection.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     *
     *
     */
    public static boolean isEmpty(Map<?, ?> map){
        if(map == null || map.isEmpty()){
            return true;
        }

        return false;
    }
}
