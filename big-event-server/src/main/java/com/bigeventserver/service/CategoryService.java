package com.bigeventserver.service;

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
}
