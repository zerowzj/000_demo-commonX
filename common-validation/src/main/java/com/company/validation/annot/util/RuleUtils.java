package com.company.validation.annot.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class RuleUtils {
	
	/** 验证规则注解包结尾（判断注解是否是验证规则注解的依据） */
//	public static String RULE_PACKAGE = StringUtils.substringLastBefore(RuleUtils.class.getPackage().getName(), ".");
	public static String RULE_PACKAGE = null;

	static {
		RULE_PACKAGE = RULE_PACKAGE + ".rule";
	}

	/**
	 * 是否有规则注解
	 * 
	 * @param field
	 * @return boolean
	 */
	public static boolean haveRuleAnnotation(final Field field){
		Annotation[] annotArr = field.getAnnotations();
		if(annotArr == null){
			return false;
		} else {
			int counter = 0;
			for(Annotation annot : annotArr) {
				if(isRuleAnnotation(annot)){
					counter++;
				}
			}
			if(counter > 0){
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 * 获取规则注解
	 * 
	 * @param field
	 * @return List<Annotation>
	 */
	public static List<Annotation> getRuleAnnotations(final Field field) {
		Annotation[] annotArr = field.getAnnotations();
		List<Annotation> annotLt = new ArrayList<Annotation>();
		for(Annotation annot : annotArr){
			if(isRuleAnnotation(annot)){
				annotLt.add(annot);
			}
		}
		return annotLt;
	}
	
	/**
	 * 是否是规则注解
	 * 
	 * @param annot
	 * @return boolean
	 */
	public static boolean isRuleAnnotation(Annotation annot){
		Package pk =  annot.annotationType().getPackage();
		return pk.getName().endsWith(RULE_PACKAGE);
	}
}
