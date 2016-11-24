package com.company.util;

import sun.reflect.generics.reflectiveObjects.TypeVariableImpl;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

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
    public static <T> T cast(Object obj){

        try {
            Type type = TypeCastUtil.class.getMethod("cast", Object.class).getReturnType();

            TypeVariableImpl t = (TypeVariableImpl) type;
            System.out.println(t);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if(obj == null){
            return null;
        }
        obj.getClass();
        return (T) obj;
    }

    public static void main(String[] args) {
        String str = "";
        String aa = TypeCastUtil.cast(str);
    }
}
