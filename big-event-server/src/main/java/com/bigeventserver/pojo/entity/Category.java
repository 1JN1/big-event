package com.bigeventserver.pojo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 
 * @author 王文涛
 * @TableName category
 */
@Schema(description = "分类实体类")
@Data
public class Category implements Serializable {
    /**
     * ID
     */
    @Schema(description = "ID")
    private Integer id;

    /**
     * 分类名称
     */
    @Schema(description = "分类名称")
    private String categoryName;

    /**
     * 分类别名
     */
    @Schema(description = "分类别名")
    private String categoryAlias;

    /**
     * 创建人ID
     */
    @Schema(description = "创建人ID")
    private Integer createUser;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private LocalDateTime updateTime;

    @Schema(hidden = true)
    private static final long serialVersionUID = 1L;
}