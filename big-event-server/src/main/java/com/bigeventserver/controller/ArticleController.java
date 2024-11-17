package com.bigeventserver.controller;

import com.bigeventserver.pojo.dto.AddArticleDto;
import com.bigeventserver.pojo.dto.ArticlePageDto;
import com.bigeventserver.pojo.dto.UpdateArticleDto;
import com.bigeventserver.pojo.entity.Article;
import com.bigeventserver.pojo.vo.PageResult;
import com.bigeventserver.pojo.vo.Result;
import com.bigeventserver.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping
    @Operation(summary = "更新文章")
    public Result<String> update(@RequestBody @Valid UpdateArticleDto updateArticleDto) {

        log.info("更新文章, updateArticleDto: {}", updateArticleDto);

        articleService.update(updateArticleDto);

        return Result.success();
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "根据id获取文章详情")
    public Result<Article> detail(@PathVariable Long id) {

        log.info("根据id获取文章详情, id: {}", id);

        Article article = articleService.detail(id);

        return Result.success(article);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "根据id删除文章")
    public Result<String> delete(@PathVariable Long id) {

        log.info("根据id删除文章, id: {}", id);

        articleService.delete(id);

        return Result.success();
    }

    @GetMapping
    @Operation(summary = "分页条件查询")
    public Result<PageResult<Article>> list(@Valid ArticlePageDto articlePageDto) {

        log.info("分页条件查询, articlePageDto: {}", articlePageDto);

        PageResult<Article> articles = articleService.list(articlePageDto);

        return Result.success(articles);
    }
}
