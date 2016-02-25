package com.company.common.validation.factory;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import com.company.common.validation.validator.DateValidator;
import com.company.common.validation.validator.StringValidator;
import com.company.common.validation.validator.Validator;

public class DefaultValidatorFactory implements ValidatorFactory {

	private static Map<String, Validator> validator = new HashMap<String, Validator>();

	static {
		validator.put("com.company.project.module.validation.rule.StringRule", new StringValidator());
		validator.put("com.company.project.module.validation.rule.DateRule", new DateValidator());
	}

	@Override
	public Validator getValidator(Annotation annot) {
		return validator.get(annot.annotationType().getName());
	}
}
