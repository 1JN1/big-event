package com.bigeventserver.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description
 **/

@Schema(description = "用户登录请求参数")
@Data
public class UserLoginDto {

    @Schema(description = "用户名")
    @Pattern(regexp = "^\\S{4,16}$")
    private String username;

    @NotEmpty
    @Pattern(regexp = "^\\S{5,16}$")
    @Schema(description = "密码")
    private String password;
}
