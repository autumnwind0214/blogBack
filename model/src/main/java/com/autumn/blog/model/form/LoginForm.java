package com.autumn.blog.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


/**
 * @author autumn
 * @description 登录表单
 * @date 2024年11月09日
 * @version: 1.0
 */
@Data
public class LoginForm {

    @Schema(description = "用户名")
    String username;

    @Schema(description = "密码")
    String password;
}
