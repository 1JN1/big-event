package com.bigeventserver.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description
 **/

@Data
@Schema(description = "更新密码所需参数")
public class UpdatePwdDto {

    @NotEmpty
    @Schema(description = "旧密码")
    @Pattern(regexp = "^\\S{5,16}$")
    private String oldPwd;

    @NotEmpty
    @Schema(description = "新密码")
    @Pattern(regexp = "^\\S{5,16}$")
    private String newPwd;

    @NotEmpty
    @Schema(description = "重复新密码")
    @Pattern(regexp = "^\\S{5,16}$")
    private String rePwd;

}
