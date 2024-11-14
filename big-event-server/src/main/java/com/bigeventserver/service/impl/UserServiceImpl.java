package com.bigeventserver.service.impl;

import com.bigeventserver.constant.UserConstant;
import com.bigeventserver.exception.UserExistException;
import com.bigeventserver.mapper.UserMapper;
import com.bigeventserver.pojo.dto.UserLoginDto;
import com.bigeventserver.pojo.entity.User;
import com.bigeventserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     *
     * @param userLoginDto
     */
    @Override
    public void register(UserLoginDto userLoginDto) {


        User user = userMapper.getUserByUserName(userLoginDto.getUsername());

        if (user != null) {
            throw new UserExistException(UserConstant.USER_EXIST);
        }

        user = User.builder()
                .username(userLoginDto.getUsername())
                .password(userLoginDto.getPassword())
                .nickname(UserConstant.DEFAULT_NICKNAME)
                .build();

        userMapper.addUser(user);

    }
}
