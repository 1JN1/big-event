package com.bigeventserver.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description
 **/
@Data
@Schema(description = "新增文章分类请求参数")
public class CategoryDto {

    @NotEmpty
    @Schema(description = "分类名称")
    private String categoryName;

    @NotEmpty
    @Schema(description = "分类别名")
    private String categoryAlias;

}
