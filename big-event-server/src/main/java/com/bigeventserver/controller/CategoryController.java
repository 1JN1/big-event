package com.bigeventserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王文涛
 * @date 2024/11/13
 * @description
 **/
@Tag(name = "文档分类相关接口")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @GetMapping
    @Operation(summary = "测试")
    public String test() {

        return "test";
    }

}
