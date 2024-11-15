package com.autumn.blog.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author autumn
 * @description 用户信息
 * @date 2024年11月14日
 * @version: 1.0
 */
@Data
public class UserInfoVo {
    Long id;
    String phone;
    String nickname;
    String logo;
    Integer age;
    Integer sex;
    String email;
    Date lastLoginTime;
    Date createTime;
    Date updateTime;
    String username;
}
