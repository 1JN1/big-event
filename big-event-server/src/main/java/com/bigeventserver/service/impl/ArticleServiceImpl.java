package com.bigeventserver.service.impl;

import com.bigeventserver.constant.ExceptionConstant;
import com.bigeventserver.exception.CategoryNotExist;
import com.bigeventserver.mapper.ArticleMapper;
import com.bigeventserver.mapper.CategoryMapper;
import com.bigeventserver.pojo.dto.AddArticleDto;
import com.bigeventserver.pojo.dto.ArticlePageDto;
import com.bigeventserver.pojo.dto.UpdateArticleDto;
import com.bigeventserver.pojo.entity.Article;
import com.bigeventserver.pojo.entity.Category;
import com.bigeventserver.pojo.vo.PageResult;
import com.bigeventserver.service.ArticleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 新增文章
     *
     * @param addArticleDto
     */
    @Override
    public void add(AddArticleDto addArticleDto) {

        Category category = categoryMapper.getById(addArticleDto.getCategoryId());

        // 文章分类不存在
        if (category == null) {
            throw new CategoryNotExist(ExceptionConstant.CATEGORY_NOT_EXIST);
        }

        Article article = new Article();

        BeanUtils.copyProperties(addArticleDto, article);

        // 由于没有做OSS文件上传，这里的文章封面是假数据
        article.setCoverImg("https://gips0.baidu.com/it/u=1690853528,2506870245&fm=3028&app=3028&f=JPEG&fmt=auto?w=1024&h=1024");

        articleMapper.insert(article);
    }

    /**
     * 更新文章
     *
     * @param updateArticleDto
     */
    @Override
    public void update(UpdateArticleDto updateArticleDto) {

        Category category = categoryMapper.getById(updateArticleDto.getCategoryId());

        // 文章分类不存在
        if (category == null) {
            throw new CategoryNotExist(ExceptionConstant.CATEGORY_NOT_EXIST);
        }

        Article article = new Article();
        BeanUtils.copyProperties(updateArticleDto, article);

        articleMapper.update(article);
    }

    /**
     * 根据id获取文章详情
     *
     * @param id
     * @return
     */
    @Override
    public Article detail(Long id) {

        return articleMapper.getById(id);
    }

    /**
     * 根据id删除文章
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        articleMapper.deleteById(id);
    }

    /**
     * 分页条件查询
     *
     * @param articlePageDto
     * @return
     */
    @Override
    public PageResult<Article> list(ArticlePageDto articlePageDto) {


        PageHelper.startPage(articlePageDto.getPage(), articlePageDto.getSize());

        Page<Article> articlePage = articleMapper.list(articlePageDto);

        return new PageResult<>(articlePage.getTotal(), articlePage.getResult());
    }
}
