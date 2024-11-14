package com.bigeventserver.controller;

import com.bigeventserver.pojo.dto.UserLoginDto;
import com.bigeventserver.pojo.vo.Result;
import com.bigeventserver.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王文涛
 * @date 2024/11/13
 * @description
 **/
@Tag(name = "用户相关接口")
@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result<String> register(@RequestBody UserLoginDto userLoginDto) {

        log.info("注册, userLoginDto: {}", userLoginDto);

        userService.register(userLoginDto);

        return Result.success();
    }


}
