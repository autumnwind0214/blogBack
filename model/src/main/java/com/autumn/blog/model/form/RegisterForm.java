package com.autumn.blog.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author autumn
 * @description 注册表单
 * @date 2024年11月12日
 * @version: 1.0
 */
@Data
public class RegisterForm {

    @Schema(description = "用户名")
    String username;

    @Schema(description = "密码")
    String password;
}
