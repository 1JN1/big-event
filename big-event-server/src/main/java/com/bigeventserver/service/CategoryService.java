package com.bigeventserver.service;

import com.bigeventserver.pojo.dto.CategoryDto;
import com.bigeventserver.pojo.dto.UpdateCategoryDto;
import com.bigeventserver.pojo.vo.CategoryVo;

import java.util.List;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description
 **/
public interface CategoryService {

    /**
     * 获取文章所有分类信息
     *
     * @return
     */
    List<CategoryVo> list();

    /**
     * 新增文章分类
     *
     * @param categoryDto
     */
    void add(CategoryDto categoryDto);

    /**
     * 更新文章分类
     *
     * @param updateCategoryDto
     */
    void update(UpdateCategoryDto updateCategoryDto);

    /**
     * 根据id获取文章分类详情
     *
     * @param id
     * @return
     */
    CategoryVo getDetail(Long id);
}
