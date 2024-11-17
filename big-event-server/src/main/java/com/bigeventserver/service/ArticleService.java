package com.bigeventserver.service;

import com.bigeventserver.pojo.dto.AddArticleDto;
import com.bigeventserver.pojo.dto.ArticlePageDto;
import com.bigeventserver.pojo.dto.UpdateArticleDto;
import com.bigeventserver.pojo.entity.Article;
import com.bigeventserver.pojo.vo.PageResult;

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

    /**
     * 根据id获取文章详情
     *
     * @param id
     * @return
     */
    Article detail(Long id);

    /**
     * 根据id删除文章
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 分页条件查询
     *
     * @param articlePageDto
     * @return
     */
    PageResult<Article> list(ArticlePageDto articlePageDto);
}
