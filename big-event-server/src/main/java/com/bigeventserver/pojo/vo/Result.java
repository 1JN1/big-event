package com.bigeventserver.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description
 **/

@Schema(description = "统一返回格式")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result<T> implements Serializable {

    private String msg;

    private Integer code;

    private T data;

    public static <T> Result<T> success(T data) {

        return new Result<>("请求成功", 0, data);
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>(msg, 1, null);
    }

}
