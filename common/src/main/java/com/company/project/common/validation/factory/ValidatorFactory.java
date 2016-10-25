package com.company.project.common.validation.factory;

import java.lang.annotation.Annotation;

import com.company.project.common.validation.validator.Validator;

public interface ValidatorFactory {

	public Validator getValidator(Annotation annot);
}
