package com.bigeventserver.service.impl;

import com.bigeventserver.constant.ExceptionConstant;
import com.bigeventserver.constant.UserConstant;
import com.bigeventserver.exception.NewPasswordEqualOldPwdException;
import com.bigeventserver.exception.PasswordErrException;
import com.bigeventserver.exception.UserExistException;
import com.bigeventserver.exception.UserNotFoundException;
import com.bigeventserver.mapper.UserMapper;
import com.bigeventserver.pojo.dto.UpdatePwdDto;
import com.bigeventserver.pojo.dto.UpdateUserDto;
import com.bigeventserver.pojo.dto.UserLoginDto;
import com.bigeventserver.pojo.entity.User;
import com.bigeventserver.pojo.vo.UserVo;
import com.bigeventserver.service.UserService;
import com.bigeventserver.utils.ThreadLocalUtil;
import org.springframework.beans.BeanUtils;
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
            throw new UserExistException(ExceptionConstant.USER_EXIST);
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
            throw new UserNotFoundException(ExceptionConstant.USER_NOT_EXIST);
        }

        String password = userLoginDto.getPassword();

        // md5加密后的密码
        String string = DigestUtils.md5DigestAsHex(password.getBytes());

        // 密码错误
        if (!string.equals(user.getPassword())) {
            throw new PasswordErrException(ExceptionConstant.PASSWORD_ERROR);
        }


        return user;
    }

    /**
     * 获取用户详细信息
     *
     * @return
     */
    @Override
    public UserVo getUserInfo() {

        // 获取用户id
        Long userId = ThreadLocalUtil.getUserId();

        User user = userMapper.getUserById(userId);

        if (user == null) {
            throw new UserNotFoundException(ExceptionConstant.USER_NOT_EXIST);
        }

        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);

        return userVo;
    }

    /**
     * 更新用户
     *
     * @param userLoginDto
     */
    @Override
    public void update(UpdateUserDto userLoginDto) {

        User user = new User();

        BeanUtils.copyProperties(userLoginDto, user);

        user.setId(ThreadLocalUtil.getUserId());

        userMapper.update(user);
    }

    /**
     * 更新用户密码
     *
     * @param updatePwdDto
     */
    @Override
    public void updatePwd(UpdatePwdDto updatePwdDto) {

        User user = userMapper.getUserById(ThreadLocalUtil.getUserId());

        // 旧密码
        String oldPwd = user.getPassword();
        // 加密后的新密码
        String md5NewPwd = DigestUtils.md5DigestAsHex(updatePwdDto.getNewPwd().getBytes());
        // 用户输入的加密后的旧密码
        String inputMd5OldPwd = DigestUtils.md5DigestAsHex(updatePwdDto.getOldPwd().getBytes());


        // 旧密码错误
        if (!oldPwd.equals(inputMd5OldPwd)) {
            throw new PasswordErrException(ExceptionConstant.PASSWORD_ERROR);
        }

        // 两次输入的新密码不一致
        if (!updatePwdDto.getNewPwd().equals(updatePwdDto.getRePwd())) {
            throw new PasswordErrException(ExceptionConstant.TWICE_NOT_EQUAL);
        }

        // 新密码与旧密码相同
        if (oldPwd.equals(md5NewPwd)) {
            throw new NewPasswordEqualOldPwdException(ExceptionConstant.NEW_PWD_EQUAL_OLD_PWD);
        }

        // 修改密码
        user.setPassword(md5NewPwd);

        userMapper.update(user);
    }
}
