package com.autumn.blog.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author autumn
 * @description 用户信息
 * @date 2024年11月12日
 * @version: 1.0
 */
@Data
public class UserVo {

    @Schema(description = "用户名")
    String username;

    String token;
}
