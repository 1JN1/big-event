package com.bigeventserver.pojo.dto;

import com.bigeventserver.annotation.Status;
import io.swagger.v3.oas.annotations.media.PatternProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description
 **/
@Schema(description = "新增文章请求参数")
@Data
public class AddArticleDto implements Serializable {

    @NotEmpty
    @Schema(description = "文章标题")
    private String title;

    @NotEmpty
    @Schema(description = "文章正文")
    private String content;

    @NotEmpty
    @Status
    @Schema(description = "发布状态", allowableValues = {"已发布", "草稿"})
    private String state;

    @NotNull
    @Schema(description = "文章分类ID")
    private Long categoryId;

}
