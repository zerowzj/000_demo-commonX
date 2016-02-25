package com.company.common.validation.factory;

import java.lang.annotation.Annotation;

import com.company.common.validation.validator.Validator;

public interface ValidatorFactory {

	public Validator getValidator(Annotation annot);
}
