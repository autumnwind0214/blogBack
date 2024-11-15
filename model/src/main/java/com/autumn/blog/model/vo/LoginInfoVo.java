package com.autumn.blog.model.vo;

import lombok.Data;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Data
public class LoginInfoVo {
    String name;
    String accessToken;
    UserInfoVo userInfo;
}
