package com.bigeventserver.pojo.vo;

import com.bigeventserver.pojo.entity.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 王文涛
 * @date 2024/11/18
 * @description
 **/

@Schema(description = "分页请求返回参数")
@Data
public class ArticleVo implements Serializable {

    /**
     * ID
     */
    @Schema(description = "ID")
    private Long id;

    /**
     * 文章标题
     */
    @Schema(description = "文章标题")
    private String title;

    /**
     * 文章内容
     */
    @Schema(description = "文章内容")
    private String content;

    /**
     * 文章封面
     */
    @Schema(description = "文章封面")
    private String coverImg;

    /**
     * 文章状态: 只能是[已发布] 或者 [草稿]
     */
    @Schema(description = "文章状态: 只能是[已发布] 或者 [草稿]")
    private String state;

    /**
     * 文章分类
     */
    @Schema(description = "文章分类")
    private Category category;

    /**
     * 创建人ID
     */
    @Schema(description = "创建人ID")
    private Long createUser;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @Schema(hidden = true)
    private static final long serialVersionUID = 1L;

}
