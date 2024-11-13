package com.bigeventserver.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
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
public class UserController {
}
