package com.bigeventserver.exception;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description 自定义基础异常，其他异常的顶级父类
 **/

public class BaseException extends RuntimeException {

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

}
