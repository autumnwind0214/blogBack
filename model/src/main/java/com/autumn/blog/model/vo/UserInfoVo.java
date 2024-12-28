package com.autumn.blog.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author autumn
 * @description 用户信息
 * @date 2024年11月14日
 * @version: 1.0
 */
@Data
public class UserInfoVo {
    private Long id;
    private String phone;
    private String nickname;
    private String logo;
    private Integer age;
    private Integer sex;
    private String email;
    private LocalDateTime lastLoginTime;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String username;

    // 角色信息
    private String roleInfo;

    // 角色ID,多个逗号分隔
    private String roleIds;
}
