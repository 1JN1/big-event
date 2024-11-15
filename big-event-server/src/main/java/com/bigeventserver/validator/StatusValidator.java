package com.bigeventserver.validator;

import com.bigeventserver.annotation.Status;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description
 **/
public class StatusValidator implements ConstraintValidator<Status, String> {

    /**
     * 可接受的值
     */
    private String[] acceptedValues;

    @Override
    public void initialize(Status constraintAnnotation) {
        this.acceptedValues = constraintAnnotation.acceptedValues();
    }

    @Override
    public boolean isValid(String status, ConstraintValidatorContext constraintValidatorContext) {

        if (status == null) {
            return false;
        }
        for (String acceptedValue : acceptedValues) {
            if (acceptedValue.equals(status)) {
                return true;
            }
        }
        return false;

    }
}
