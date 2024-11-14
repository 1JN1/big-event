package com.bigeventserver.constant;

import java.util.UUID;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description 用户相关的常量
 **/
public class UserConstant {

    /**
     * 默认昵称
     */
    public static final String DEFAULT_NICKNAME = "用户_" + UUID.randomUUID();

    public static final String USER_EXIST = "用户已经存在";

}
