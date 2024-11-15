package com.bigeventserver.service;

import com.bigeventserver.pojo.dto.AddArticleDto;
import com.bigeventserver.pojo.dto.UpdateArticleDto;

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

    /**
     * 更新文章
     *
     * @param updateArticleDto
     */
    void update(UpdateArticleDto updateArticleDto);
}
