package com.bigeventserver.service.impl;

import com.bigeventserver.mapper.CategoryMapper;
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
}
