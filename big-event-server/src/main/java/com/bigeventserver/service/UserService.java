package com.bigeventserver.service;

import com.bigeventserver.pojo.dto.UserLoginDto;
import com.bigeventserver.pojo.entity.User;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description
 **/
public interface UserService {

    /**
     * 用户注册
     *
     * @param userLoginDto
     */
    void register(UserLoginDto userLoginDto);

    /**
     * 用户登录
     *
     * @param userLoginDto
     * @return
     */
    User login(UserLoginDto userLoginDto);
}
