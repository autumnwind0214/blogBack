package com.autumn.blog.model.vo;

import lombok.Data;

/**
 * @author autumn
 * @description TODO
 * @date 2025年01月07日
 * @version: 1.0
 */
@Data
public class AuthInfoVo {
    String accessToken;
    String refreshToken;
}
