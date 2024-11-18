package com.bigeventserver.pojo.dto;

import com.bigeventserver.annotation.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

/**
 * @author 王文涛
 * @date 2024/11/17
 * @description
 **/
@Schema(description = "条件分页查询文章请求参数")
@Data
@Builder
public class ArticlePageDto {

    @Schema(description = "当前页", defaultValue = "1")
    @NotNull
    @Min(1)
    private Integer page;

    @Schema(description = "每页大小", defaultValue = "10")
    @NotNull
    @Min(1)
    private Integer size;

    @Schema(description = "分类名")
    private String categoryName;

    @Schema(description = "发布状态")
    @Status
    private String state;

}
