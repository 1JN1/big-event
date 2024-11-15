package com.bigeventserver.controller;

import com.bigeventserver.constant.JwtClaimsConstant;
import com.bigeventserver.pojo.dto.UpdatePwdDto;
import com.bigeventserver.pojo.dto.UpdateUserDto;
import com.bigeventserver.pojo.dto.UserLoginDto;
import com.bigeventserver.pojo.entity.User;
import com.bigeventserver.pojo.vo.Result;
import com.bigeventserver.pojo.vo.UserVo;
import com.bigeventserver.properties.JwtProperties;
import com.bigeventserver.service.UserService;
import com.bigeventserver.utils.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/register")
    @Operation(summary = "用户注册")
    public Result<String> register(@RequestBody @Valid UserLoginDto userLoginDto) {

        log.info("注册, userLoginDto: {}", userLoginDto);

        userService.register(userLoginDto);

        return Result.success();
    }

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public Result<String> login(@RequestBody @Valid UserLoginDto userLoginDto) {

        log.info("用户登录, userLoginDto: {}", userLoginDto);

        User user = userService.login(userLoginDto);

        // 构建jwt令牌

        Map<String, Object> claims = new HashMap<>(2);

        claims.put(JwtClaimsConstant.USER_ID, user.getId());

        Long ttl = jwtProperties.getTtl();

        String jwt = JwtUtil.createJwt(jwtProperties.getSecretKey(), ttl, claims);

        String key = jwtProperties.getTokenName();

        redisTemplate.opsForValue().set(key, jwt);
        redisTemplate.expire(key, ttl, TimeUnit.MILLISECONDS);

        return Result.success(jwt);
    }

    @GetMapping("/userInfo")
    @Operation(summary = "获取用户详细信息")
    @Cacheable(cacheNames = "userInfoCache", key = "T(com.bigeventserver.utils.ThreadLocalUtil).userId")
    public Result<UserVo> userInfo() {

        UserVo user = userService.getUserInfo();

        return Result.success(user);
    }


    @PutMapping("/update")
    @Operation(summary = "更新用户")
    @CacheEvict(cacheNames = "userInfoCache", key = "T(com.bigeventserver.utils.ThreadLocalUtil).userId")
    public Result<String> update(@RequestBody @Valid UpdateUserDto userLoginDto) {

        log.info("更新用户, userLoginDto: {}", userLoginDto);

        userService.update(userLoginDto);

        return Result.success();
    }

    @PatchMapping("/updatePwd")
    @Operation(summary = "更新用户密码")
    public Result<String> updatePwd(@RequestBody @Valid UpdatePwdDto updatePwdDto) {

        log.info("更新用户密码, userLoginDto: {}", updatePwdDto);

        userService.updatePwd(updatePwdDto);

        redisTemplate.delete(jwtProperties.getTokenName());

        return Result.success();
    }

}
