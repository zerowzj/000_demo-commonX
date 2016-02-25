package com.company.common.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.common.util.ReflectUtils;
import com.company.common.validation.factory.DefaultValidatorFactory;
import com.company.common.validation.rule.NotEmpty;
import com.company.common.validation.validator.Validator;

/**
 * 验证Utils
 * 
 * @author wangzhj
 */
public class ValidatorUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(ValidatorUtils.class);
	
	/** 验证规则注解包结尾（判断注解是否是验证规则注解的依据） */
	private static final String RULE_PACKAGE_END =  ".validation.rule";

	/**
	 * 验证
	 * 
	 * @param bean
	 */
	public static void validate(final Object bean) {
		
		logger.info("验证类型{}的对象属性", bean.getClass().getName());
		//
		Class<?> cls = bean.getClass();
		for (; cls != Object.class; cls = cls.getSuperclass()) {
			//遍历属性
			Field[] fieldArr = cls.getDeclaredFields();
			for (Field field : fieldArr) {
				//无注解
				Annotation[] annotArr = field.getAnnotations();
				if(annotArr == null){
					
					continue;
				}
				
				//获取属性值
				Object value = ReflectUtils.getFieldValue(bean, field);
				
				//
				if(field.isAnnotationPresent(NotEmpty.class)){
					
				}
				//
				for(Annotation annot : annotArr) {
					if(isRuleAnnotation(annot)){
						Validator validator = new DefaultValidatorFactory().getValidator(annot);
						if(validator.suppport(field.getType())){
							validator.validate(field.getName(), value, annot);
						} else {
							
						}
					}
				}
				
				//处理嵌套属性
				Class<?> ftype = field.getType();
				if (isCollection(ftype)) { //Collection
					Collection<?> list = (Collection<?>) value;
					if(list != null) {
						for(Object nestObj : list){
							validate(nestObj);
						}
					}
				} else if(isMap(ftype)){ //Map
					Map<?, ?> map = (Map<?, ?>) value;
						for(Object nestObj : map.values()){
							validate(nestObj);
						}
				} else if(isArray(ftype)){ //Array
					Object[] array = (Object[])value;
					for(Object nestObj : array){
						validate(nestObj);
					}
				}
			}
		}
	}
	
	/**
	 * 是否是规则注解
	 * 
	 * @param annot
	 * @return boolean
	 */
	private static boolean isRuleAnnotation(Annotation annot){
		Package pk =  annot.annotationType().getPackage();
		return pk.getName().endsWith(RULE_PACKAGE_END);
	}
	
	/**
	 * 是否是数组类型
	 * 
	 * @param clazz
	 * @return boolean
	 */
	private static boolean isArray(Class<?> clazz){
		return clazz.isArray();
	}
	/**
	 * 是否是规则注解
	 * 
	 * @param clazz
	 * @return boolean
	 */
	private static boolean isCollection(Class<?> clazz){
		return clazz.isAssignableFrom(List.class) || clazz.isAssignableFrom(List.class);
	}
	/**
	 * 是否是规则注解
	 * 
	 * @param clazz
	 * @return boolean
	 */
	private static boolean isMap(Class<?> clazz){
		return clazz.isAssignableFrom(Map.class);
	}
}
