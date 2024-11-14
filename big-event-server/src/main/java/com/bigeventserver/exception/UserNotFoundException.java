package com.bigeventserver.exception;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description
 **/
public class UserNotFoundException extends BaseException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
