package com.bigeventserver.service.impl;

import com.bigeventserver.constant.UserConstant;
import com.bigeventserver.exception.PasswordErrException;
import com.bigeventserver.exception.UserExistException;
import com.bigeventserver.exception.UserNotFoundException;
import com.bigeventserver.mapper.UserMapper;
import com.bigeventserver.pojo.dto.UserLoginDto;
import com.bigeventserver.pojo.entity.User;
import com.bigeventserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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

        String password = DigestUtils.md5DigestAsHex(userLoginDto.getPassword().getBytes());

        user = User.builder()
                .username(userLoginDto.getUsername())
                .password(password)
                .nickname(UserConstant.DEFAULT_NICKNAME)
                .build();

        userMapper.addUser(user);

    }

    /**
     * 用户登录
     *
     * @param userLoginDto
     * @return
     */
    @Override
    public User login(UserLoginDto userLoginDto) {

        User user = userMapper.getUserByUserName(userLoginDto.getUsername());

        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }

        String password = userLoginDto.getPassword();

        // md5加密后的密码
        String string = DigestUtils.md5DigestAsHex(password.getBytes());

        // 密码错误
        if (!string.equals(user.getPassword())) {
            throw new PasswordErrException("用户密码错误");
        }


        return user;
    }
}
