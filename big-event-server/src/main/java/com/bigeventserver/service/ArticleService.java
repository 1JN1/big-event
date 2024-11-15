package com.bigeventserver.service;

import com.bigeventserver.pojo.dto.AddArticleDto;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description
 **/
public interface ArticleService {

    /**
     * 新增文章
     *
     * @param addArticleDto
     */
    void add(AddArticleDto addArticleDto);
}
