package com.bigeventserver.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description
 **/
@Data
@Schema(description = "更新文章分类请求参数")
public class UpdateCategoryDto {

    @NotNull
    @Schema(description = "ID")
    private Long id;

    @NotEmpty
    @Schema(description = "分类名称")
    private String categoryName;

    @NotEmpty
    @Schema(description = "分类别名")
    private String categoryAlias;

}
