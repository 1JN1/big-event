package com.bigeventserver.aspect;

import com.bigeventserver.annotation.AutoFill;
import com.bigeventserver.constant.AutoFillConstant;
import com.bigeventserver.utils.ThreadLocalUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description 自动填充切面
 **/
@Aspect
@Component
public class AutoFillAspect {

    private static final Logger log = LoggerFactory.getLogger(AutoFillAspect.class);

    @Pointcut("execution(* com.bigeventserver.mapper.*.*(..)) && @annotation(com.bigeventserver.annotation.AutoFill)")
    public void autoFillPointcut() {
    }

    @Before("autoFillPointcut()")
    public void before(JoinPoint joinPoint) {

        log.info("开始填充公共字段");

        // 获取注解值
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);

        // 获取到方法的参数
        Object[] args = joinPoint.getArgs();

        if (args == null || args.length == 0) {
            log.info("参数不合理");
            return;
        }

        Object object = args[0];

        LocalDateTime now = LocalDateTime.now();

        switch (autoFill.value()) {
            case INSERT -> {

                try {
                    Method m1 = object.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
                    Method m2 = object.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);

                    try {
                        Method m3 = object.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_USER, Long.class);
                        m3.invoke(object, ThreadLocalUtil.getUserId());
                    } catch (Exception e) {

                    }

                    m1.invoke(object, now);
                    m2.invoke(object, now);

                } catch (Exception e) {
                    log.error(e.getMessage());
                }

            }

            case UPDATE -> {

                try {
                    Method m2 = object.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);

                    m2.invoke(object, now);

                } catch (Exception e) {
                    log.error(e.getMessage());
                }

            }

            default -> {
            }
        }


    }

}
