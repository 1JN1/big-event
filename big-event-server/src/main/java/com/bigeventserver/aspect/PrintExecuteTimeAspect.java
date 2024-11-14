package com.bigeventserver.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description 打印接口方法执行时间的切面类
 **/

@Aspect
@Component
public class PrintExecuteTimeAspect {

    private static final Logger log = LoggerFactory.getLogger(PrintExecuteTimeAspect.class);

    @Around("execution(* com.bigeventserver.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        log.info("{}执行时间{} ms", joinPoint, endTime - startTime);

        return result;
    }

}
