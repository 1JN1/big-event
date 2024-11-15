package com.bigeventserver.exception;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description
 **/
public class NewPasswordEqualOldPwdException extends BaseException{

    public NewPasswordEqualOldPwdException() {}

    public NewPasswordEqualOldPwdException(String message) {super(message);}

}
