package com.bigeventserver.service;

import com.bigeventserver.pojo.dto.UserLoginDto;

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
}
