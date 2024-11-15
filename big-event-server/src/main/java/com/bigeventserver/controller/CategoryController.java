package com.bigeventserver.controller;

import com.bigeventserver.pojo.dto.CategoryDto;
import com.bigeventserver.pojo.dto.UpdateCategoryDto;
import com.bigeventserver.pojo.vo.CategoryVo;
import com.bigeventserver.pojo.vo.Result;
import com.bigeventserver.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 王文涛
 * @date 2024/11/13
 * @description
 **/
@Tag(name = "文档分类相关接口")
@RestController
@RequestMapping("/api/category")
@Slf4j
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @Operation(summary = "获取分类信息")
    @Cacheable(cacheNames = "categoryListCache")
    public Result<List<CategoryVo>> list() {

        log.info("获取文章所有分类信息");

        List<CategoryVo> categoryVos = categoryService.list();

        return Result.success(categoryVos);
    }


    @PostMapping
    @Operation(summary = "新增文章分类")
    @CacheEvict(cacheNames = "categoryListCache", allEntries = true)
    public Result<String> add(@RequestBody @Valid CategoryDto categoryDto) {

        log.info("新增文章分类, categoryDto={}", categoryDto);

        categoryService.add(categoryDto);

        return Result.success();
    }

    @PutMapping
    @Operation(summary = "更新文章分类")
    @CacheEvict(cacheNames = "categoryListCache", allEntries = true)
    public Result<String> update(@RequestBody @Valid UpdateCategoryDto updateCategoryDto) {

        log.info("更新文章, updateCategoryDto={}", updateCategoryDto);

        categoryService.update(updateCategoryDto);

        return Result.success();
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "根据id获取文章分类详情")
    public Result<CategoryVo> detail(@PathVariable Long id) {

        log.info("根据id获取文章分类详情, id={}", id);

        CategoryVo categoryVo = categoryService.getDetail(id);

        return Result.success(categoryVo);
    }


}
