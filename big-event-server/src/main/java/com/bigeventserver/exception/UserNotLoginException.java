package com.bigeventserver.exception;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description
 **/
public class UserNotLoginException extends BaseException {

    public UserNotLoginException() {
    }

    public UserNotLoginException(String message) {
        super(message);
    }

}
