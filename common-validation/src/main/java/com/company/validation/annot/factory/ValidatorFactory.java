package com.company.validation.annot.factory;

import com.company.validation.annot.validator.Validator;

import java.lang.annotation.Annotation;

/**
 * 验证器工厂
 *
 * @author wangzhj
 */
public interface ValidatorFactory {

    public Validator getValidator(Annotation annot);
}
