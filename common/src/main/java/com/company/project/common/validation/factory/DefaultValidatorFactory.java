package com.company.project.common.validation.factory;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import com.company.project.common.validation.validator.DateValidator;
import com.company.project.common.validation.validator.StringValidator;
import com.company.project.common.validation.validator.Validator;

public class DefaultValidatorFactory implements ValidatorFactory {

	private static Map<String, Validator> validator = new HashMap<String, Validator>();

	static {
		validator.put("StringRule", new StringValidator());
		validator.put("DateRule", new DateValidator());
	}

	@Override
	public Validator getValidator(Annotation annot) {
		return validator.get(annot.annotationType().getName());
	}
}
