package com.bigeventserver.controller;

import com.bigeventserver.constant.JwtClaimsConstant;
import com.bigeventserver.pojo.dto.UserLoginDto;
import com.bigeventserver.pojo.entity.User;
import com.bigeventserver.pojo.vo.Result;
import com.bigeventserver.pojo.vo.UserVo;
import com.bigeventserver.properties.JwtProperties;
import com.bigeventserver.service.UserService;
import com.bigeventserver.utils.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/11/13
 * @description
 **/
@Tag(name = "用户相关接口")
@RequestMapping("/api/user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/register")
    @Operation(summary = "用户注册")
    public Result<String> register(@RequestBody UserLoginDto userLoginDto) {

        log.info("注册, userLoginDto: {}", userLoginDto);

        userService.register(userLoginDto);

        return Result.success();
    }

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public Result<String> login(@RequestBody UserLoginDto userLoginDto) {

        log.info("用户登录, userLoginDto: {}", userLoginDto);

        User user = userService.login(userLoginDto);

        // 构建jwt令牌

        Map<String, Object> claims = new HashMap<>();

        claims.put(JwtClaimsConstant.USER_ID, user.getId());

        String jwt = JwtUtil.createJwt(jwtProperties.getSecretKey(), jwtProperties.getTtl(), claims);

        return Result.success(jwt);
    }

    @GetMapping("/userInfo")
    @Operation(summary = "获取用户详细信息")
    @Cacheable(cacheNames = "userInfoCache", key = "T(com.bigeventserver.utils.ThreadLocalUtil).userId")
    public Result<UserVo> userInfo() {

        UserVo user = userService.getUserInfo();

        return Result.success(user);
    }
}
