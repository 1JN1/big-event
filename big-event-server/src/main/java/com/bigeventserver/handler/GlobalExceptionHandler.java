package com.bigeventserver.handler;

import com.bigeventserver.exception.BaseException;
import com.bigeventserver.pojo.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description 全局异常处理
 **/

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public Result<String> handleException(BaseException ex) {

        String message = ex.getMessage();

        log.error("发生异常：{}", message);

        return Result.error(message);
    }

}
