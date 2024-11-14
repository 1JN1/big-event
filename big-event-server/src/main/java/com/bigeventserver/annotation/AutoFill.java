package com.bigeventserver.annotation;

import com.bigeventserver.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description 自动填充注解
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {

    OperationType value();

}
