package com.bigeventserver.mapper;

import com.bigeventserver.pojo.entity.Category;
import com.bigeventserver.pojo.vo.CategoryVo;
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
}




