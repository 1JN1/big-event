package com.bigeventserver.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description
 **/
@Schema(description = "用户登录请求参数")
@Data
public class UpdateUserDto {

    @NotEmpty
    @Pattern(regexp = "^\\S{2,16}$")
    @Schema(description = "昵称")
    private String nickname;

    @NotEmpty
    @Email
    @Schema(description = "email")
    private String email;

}
