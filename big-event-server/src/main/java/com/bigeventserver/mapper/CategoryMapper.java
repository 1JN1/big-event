package com.bigeventserver.mapper;

import com.bigeventserver.annotation.AutoFill;
import com.bigeventserver.enumeration.OperationType;
import com.bigeventserver.pojo.entity.Category;
import com.bigeventserver.pojo.vo.CategoryVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 王文涛
 * @description 针对表【category】的数据库操作Mapper
 * @createDate 2024-11-13 23:48:04
 * @Entity com.bigeventserver.pojo.entity.Category
 */
@Mapper
public interface CategoryMapper {

    /**
     * 获取文章所有分类信息
     *
     * @return
     */
    @Select("SELECT * FROM category")
    List<Category> list();

    /**
     * 新增文章分类
     *
     * @param category
     */
    @Insert("INSERT INTO category(category_name, category_alias, " +
            "create_user, create_time, update_time) " +
            "VALUES (#{categoryName}, #{categoryAlias}, #{createUser}," +
            "#{createTime}, #{updateTime})")
    @AutoFill(OperationType.INSERT)
    void insert(Category category);

    /**
     * 更新文章分类
     *
     * @param category
     */
    @AutoFill(OperationType.UPDATE)
    void update(Category category);

    /**
     * 根据id获取文章分类详情
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM category WHERE id = #{id}")
    Category getById(Long id);

    /**
     * 删除文章分类
     *
     * @param id
     */
    @Delete("DELETE FROM category WHERE id = #{id}")
    void deleteById(Long id);
}




