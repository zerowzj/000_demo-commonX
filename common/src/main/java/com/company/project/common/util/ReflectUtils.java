package com.company.project.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 反射Utils
 * 
 * @author wangzhj
 */
public final class ReflectUtils {

	/**
	 * 获取参数化类数组
	 * 
	 * @param clazz
	 * @return Class<?>[]
	 */
	public static Class<?>[] getParameterizedClass(Class<?> clazz) {
		Type type = clazz.getGenericSuperclass();
		if (type == null) {
			return null;
		}
		Type[] typeArr = null;
		Class<?>[] typeClassArr = null;
		if (type instanceof ParameterizedType) {
			//参数化类型
			ParameterizedType pType = (ParameterizedType) type;
			//实际类型
			typeArr = pType.getActualTypeArguments();
			//转型Class
			typeClassArr = new Class[typeArr.length];
			for (int i = 0; i < typeArr.length; i++) {
				typeClassArr[i] = (Class<?>) typeArr[i];
			}
		}
		return typeClassArr;
	}

	/**
	 * 获取指定参数化类
	 * 
	 * @param clazz
	 * @param index
	 * @return Class<?>
	 */
	public static Class<?> getParameterizedClass(Class<?> clazz, int index) {
		if (index <= 0) {
			return null;
		}
		Class<?>[] clazzArr = getParameterizedClass(clazz);
		if (clazz == null || clazzArr.length < index) {
			return null;
		}
		return clazzArr[index - 1];
	}

	/**
	 * 实例化指定类
	 * 
	 * @param cls
	 * @return T
	 */
	public static <T> T instatnce(Class<T> cls) {
		try {
			return cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取Bean全部属性
	 * 
	 * @param bean
	 * @param excludeFieldLt
	 * @return Field[]
	 */
	public static Field[] getAllFields(Object bean, List<String> excludeFieldLt) {
		Class<?> cls = bean.getClass();
		Field[] fieldArr = new Field[] {};
		for (; cls != Object.class; cls = cls.getSuperclass()) {
			Field[] newArr = cls.getDeclaredFields();
			for (Field f : newArr) {
				if (excludeFieldLt.contains(f.getName())) {

				}
			}
			Field[] oldArr = fieldArr;
			fieldArr = new Field[oldArr.length + newArr.length];

			System.arraycopy(oldArr, 0, fieldArr, 0, oldArr.length);
			System.arraycopy(newArr, 0, fieldArr, newArr.length, newArr.length);
		}
		return fieldArr;
	}

	/**
	 * 获取Bean全部属性
	 * 
	 * @param bean
	 * @return Field[]
	 */
	public static Field[] getAllFields(Object bean) {
		return getAllFields(bean, null);
	}
	
	/**
	 * 获取Bean属性值
	 * 
	 * @param bean
	 * @param field
	 * @return Object
	 */
	public static Object getFieldValue(Object bean, Field field) {
		if(bean == null){
			return null;
		}
		Object value = null;
		try {
			field.setAccessible(true);
			value = field.get(bean);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	/**
	 * 是否是数组
	 * 
	 * @param clazz
	 * @return boolean
	 */
	public static boolean isArray(Class<?> clazz) {
		return clazz.isArray();
	}
	
	/**
	 * 是否是规则注解
	 * 
	 * @param clazz
	 * @return boolean
	 */
	public static boolean isCollection(Class<?> clazz){
		return clazz.isAssignableFrom(List.class) || clazz.isAssignableFrom(List.class);
	}
	
	/**
	 * 是否是规则注解
	 * 
	 * @param clazz
	 * @return boolean
	 */
	public static boolean isMap(Class<?> clazz){
		return clazz.isAssignableFrom(Map.class);
	}
	
	/**
	 * 是否是规则注解
	 * 
	 * @param clazz
	 * @return boolean
	 */
	public static boolean isBean(Class<?> clazz){
		return clazz.isAssignableFrom(Map.class);
	}
	
	public static boolean isAutomicField(Field field){
		
		return true;
	}
}
