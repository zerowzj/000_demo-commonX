package com.company.validation;

import com.company.exception.domain.param.EmptyValueException;
import com.company.validation.xml.Param;
import com.company.validation.xml.ParamSet;
import com.company.validation.xml.rule.Rule;
import com.company.validation.xml.validator.Validator;
import com.company.validation.xml.validator.ValidatorFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * 验证Utils
 *
 * @author wangzhj
 */
public abstract class ValidateUtil {

//	private static final Logger logger = LoggerFactory.getLogger(ValidatorUtils.class);

    /**
     * 验证
     *
     * @param paramMap
     * @param paramSet
     */
    public static void validate(Map<String, Object> paramMap, ParamSet paramSet) {

        List<Param> paramLt = paramSet.getParamLt();
        for (Param param : paramLt) {
            String paramName = param.getParamName();
            Object paramValue = paramMap.get(paramName);
            Rule rule = param.getRule();
            if (rule.isNotEmpty() && paramValue == null) {
                throw new EmptyValueException(paramName);
            }
            Validator validator = ValidatorFactory.getValidator(null);
            if (!validator.support(paramValue)) {
                throw new IllegalStateException("验证不支持的数据类型！");
            }
            validator.validate(param, paramValue);
        }
    }

    /**
     * 验证
     *
     * @param bean
     */
    public static void validate(Object bean) {
        //
//		if(bean == null){
//			logger.warn("bean is null");
//			return;
//		}
//
//		//遍历属性
//		Class<?> cls = bean.getClass();
//		for (; cls != Object.class; cls = cls.getSuperclass()) {
//			Field[] fieldArr = cls.getDeclaredFields();
//			for (Field field : fieldArr) {
//				//是否有验证规则
//				if(!RuleUtils.haveRuleAnnotation(field)){
//					continue;
//				}
//
//				//获取属性值
//				Object value = ReflectUtils.getFieldValue(bean, field);
//
//				//执行验证
//				if(ReflectUtils.isAutomicField(field)){
//					validateInternal(field, value);
//				} else {
//					validateNestInternal(field, value);
//				}
//			}
//		}
    }

    /**
     * 验证
     *
     * @param field
     * @param value
     */
    private static void validateInternal(final Field field, final Object value) {
        //
//		if(field.isAnnotationPresent(NotEmpty.class)){
//
//		}
//		//
//		List<Annotation> annotArr = RuleUtils.getRuleAnnotations(field);
//		for(Annotation annot : annotArr) {
//			DefaultValidatorFactory validatorFactory=  new DefaultValidatorFactory();
//			Validator validator = validatorFactory.getValidator(annot);
//			if(validator.suppport(field.getType())){
//				validator.validate(field.getName(), value, annot);
//			} else {
//				logger.error("规则注解{}不支持类型{}的参数", annot.annotationType().getName(), field.getType().getName());
//			}
//		}
    }

    /**
     * 验证嵌套属性
     *
     * @param field
     * @param value
     */
    private static void validateNestInternal(final Field field, final Object value) {
//		//
//		Class<?> clazz = field.getClass();
//		//处理嵌套属性
//		if (ReflectUtils.isCollection(clazz)) { //Collection
//			Collection<?> list = (Collection<?>) value;
//			if(list != null) {
//				for(Object nestObj : list){
//					validate(nestObj);
//				}
//			}
//		} else if(ReflectUtils.isMap(clazz)){ //Map
//			Map<?, ?> map = (Map<?, ?>) value;
//				for(Object nestObj : map.values()){
//					validate(nestObj);
//				}
//		} else if(ReflectUtils.isArray(clazz)){ //Array
//			Object[] array = (Object[]) value;
//			for(Object nestObj : array){
//				validate(nestObj);
//			}
//		}
    }
}
