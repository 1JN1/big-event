package com.bigeventserver.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
    private String username;

    @Schema(description = "密码")
    private String password;

}
