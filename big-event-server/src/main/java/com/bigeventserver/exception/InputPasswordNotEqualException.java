package com.bigeventserver.exception;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description
 **/
public class InputPasswordNotEqualException extends BaseException {
    public InputPasswordNotEqualException() {
    }

    public InputPasswordNotEqualException(String message) {
        super(message);
    }
}
