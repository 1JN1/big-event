package com.bigeventserver.pojo.dto;

import com.bigeventserver.annotation.Status;
import com.bigeventserver.pojo.entity.Article;
import com.bigeventserver.pojo.vo.PageResult;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * @author 王文涛
 * @date 2024/11/17
 * @description
 **/
@Schema(description = "条件分页查询文章请求参数")
@Data
public class ArticlePageDto {

    @Schema(description = "当前页", defaultValue = "1")
    @NotNull
    @Min(1)
    private Integer page;

    @Schema(description = "每页大小", defaultValue = "10")
    @NotNull
    @Min(1)
    private Integer size;

    @Schema(description = "分类ID")
    private Long categoryId;

    @Schema(description = "发布状态")
    @Status
    private String state;

}
