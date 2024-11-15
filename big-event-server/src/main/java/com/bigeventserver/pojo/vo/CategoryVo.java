package com.bigeventserver.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description
 **/

@Data
@Schema(description = "文章分类")
public class CategoryVo implements Serializable {

    /**
     * ID
     */
    @Schema(description = "ID")
    private Long id;

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
