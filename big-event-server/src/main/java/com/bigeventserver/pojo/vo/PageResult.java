package com.bigeventserver.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 王文涛
 * @date 2024/11/17
 * @description
 **/

@Schema(description = "分页查询返回对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {

    @Schema(description = "总记录数")
    private Long total;

    @Schema(description = "当前分页查询的数据")
    private List<T> items;

}
