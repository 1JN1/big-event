package com.bigeventserver.mapper;

import com.bigeventserver.annotation.AutoFill;
import com.bigeventserver.enumeration.OperationType;
import com.bigeventserver.pojo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 王文涛
 * @description 针对表【user(用户表)】的数据库操作Mapper
 * @createDate 2024-11-13 23:48:04
 * @Entity com.bigeventserver.pojo.entity.User
 */

@Mapper
public interface UserMapper {

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    @Select("SELECT * FROM user WHERE username = #{username}")
    User getUserByUserName(String username);

    /**
     * 新增用户
     *
     * @param user
     */
    @Insert("INSERT INTO user(username, password, nickname, " +
            "email, user_pic, create_time, update_time) " +
            "VALUES (#{username}, #{password}, #{nickname}, #{email}, #{userPic}, #{createTime}, #{updateTime})")
    @AutoFill(OperationType.INSERT)
    void addUser(User user);
}




