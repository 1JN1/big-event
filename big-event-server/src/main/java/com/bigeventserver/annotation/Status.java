package com.bigeventserver.annotation;

import com.bigeventserver.constant.ArticleStatusConstant;
import com.bigeventserver.validator.StatusValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author 王文涛
 */
@Documented
@Constraint(validatedBy = StatusValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface Status {

    String message() default "状态必须是'已发布'或'草稿'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] acceptedValues() default {ArticleStatusConstant.PUBLISHED, ArticleStatusConstant.DRAFT};
}