package com.bigeventserver.mapper;

import com.bigeventserver.annotation.AutoFill;
import com.bigeventserver.enumeration.OperationType;
import com.bigeventserver.pojo.dto.ArticlePageDto;
import com.bigeventserver.pojo.entity.Article;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 王文涛
 * @description 针对表【article】的数据库操作Mapper
 * @createDate 2024-11-13 23:48:04
 * @Entity com.bigeventserver.pojo.entity.Article
 */
@Mapper
public interface ArticleMapper {

    /**
     * 新增文章
     *
     * @param article
     */
    @AutoFill(OperationType.INSERT)
    @Insert("INSERT INTO article(title, content, cover_img, state, " +
            "category_id, create_user, create_time, update_time) " +
            "VALUES (#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}," +
            "#{createUser}, #{createTime}, #{updateTime})")
    void insert(Article article);

    /**
     * 更新文章
     *
     * @param article
     */
    @AutoFill(OperationType.UPDATE)
    void update(Article article);

    /**
     * 根据id获取文章
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM article WHERE id = #{id}")
    Article getById(Long id);

    /**
     * 根据id删除文章
     *
     * @param id
     */
    @Select("DELETE FROM article WHERE id = #{id}")
    void deleteById(Long id);

    /**
     * 条件查询
     *
     * @return
     */
    Page<Article> list(ArticlePageDto articlePageDto);
}




