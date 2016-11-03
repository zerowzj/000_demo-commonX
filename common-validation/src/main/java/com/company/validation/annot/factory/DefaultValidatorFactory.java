package com.company.validation.annot.factory;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import com.company.validation.annot.validator.DateValidator;
import com.company.validation.annot.validator.Validator;

public class DefaultValidatorFactory implements ValidatorFactory {

    private static Map<String, Validator> validator = new HashMap<>();

    static {
        validator.put("DateRule", new DateValidator());
    }

    @Override
    public Validator getValidator(Annotation annot) {
        return validator.get(annot.annotationType().getName());
    }
}
