package com.bigeventserver.service.impl;

import com.bigeventserver.mapper.CategoryMapper;
import com.bigeventserver.pojo.dto.CategoryDto;
import com.bigeventserver.pojo.dto.UpdateCategoryDto;
import com.bigeventserver.pojo.entity.Category;
import com.bigeventserver.pojo.vo.CategoryVo;
import com.bigeventserver.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 获取文章所有分类信息
     *
     * @return
     */
    @Override
    public List<CategoryVo> list() {

        List<CategoryVo> categoryVos = new ArrayList<>();

        List<Category> categories = categoryMapper.list();

        categories.forEach(category -> {
            CategoryVo categoryVo = new CategoryVo();
            BeanUtils.copyProperties(category, categoryVo);
            categoryVos.add(categoryVo);
        });

        return categoryVos;
    }

    /**
     * 新增文章分类
     *
     * @param categoryDto
     */
    @Override
    public void add(CategoryDto categoryDto) {

        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);

        categoryMapper.insert(category);
    }

    /**
     * 更新文章分类
     *
     * @param updateCategoryDto
     */
    @Override
    public void update(UpdateCategoryDto updateCategoryDto) {

        Category category = new Category();
        BeanUtils.copyProperties(updateCategoryDto, category);

        categoryMapper.update(category);

    }

    /**
     * 根据id获取文章分类详情
     *
     * @param id
     * @return
     */
    @Override
    public CategoryVo getDetail(Long id) {

        Category category = categoryMapper.getById(id);

        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);

        return categoryVo;
    }

    /**
     * 删除文章分类
     *
     * @param id
     */
    @Override
    public void delete(Long id) {

        categoryMapper.deleteById(id);

    }
}
