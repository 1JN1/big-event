package com.bigeventserver.exception;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description 注册用户已经存在异常
 **/
public class UserExistException extends BaseException {

    public UserExistException() {
    }

    public UserExistException(String message) {
        super(message);
    }
}
