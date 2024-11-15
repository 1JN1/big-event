package com.bigeventserver.service;

import com.bigeventserver.pojo.dto.UpdatePwdDto;
import com.bigeventserver.pojo.dto.UpdateUserDto;
import com.bigeventserver.pojo.dto.UserLoginDto;
import com.bigeventserver.pojo.entity.User;
import com.bigeventserver.pojo.vo.UserVo;

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

    /**
     * 获取用户详细信息
     *
     * @return
     */
    UserVo getUserInfo();

    /**
     * 更新用户
     *
     * @param userService
     */
    void update(UpdateUserDto userLoginDto);

    /**
     * 更新用户密码
     *
     * @param updatePwdDto
     */
    void updatePwd(UpdatePwdDto updatePwdDto);
}
