package com.bigeventserver.controller;

import com.bigeventserver.pojo.dto.AddArticleDto;
import com.bigeventserver.pojo.vo.Result;
import com.bigeventserver.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description
 **/
@Tag(name = "文章相关接口")
@RestController
@RequestMapping("/api/article")
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    @Operation(summary = "新增文章")
    public Result<String> add(@RequestBody @Valid AddArticleDto addArticleDto) {

        log.info("新增文章, addArticleDto: {}", addArticleDto);

        articleService.add(addArticleDto);

        return Result.success();
    }

}
