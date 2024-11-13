package com.bigeventserver.pojo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @author 王文涛
 * @TableName article
 */
@Data
public class Article implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章封面
     */
    private String coverImg;

    /**
     * 文章状态: 只能是[已发布] 或者 [草稿]
     */
    private String state;

    /**
     * 文章分类ID
     */
    private Integer categoryId;

    /**
     * 创建人ID
     */
    private Integer createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}