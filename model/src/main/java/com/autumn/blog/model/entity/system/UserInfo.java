package com.autumn.blog.model.entity.system;

import com.autumn.blog.common.base.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author autumn
 * @description 用户
 * @date 2024年11月15日
 * @version: 1.0
 */
@Data
public class UserInfo extends BaseEntity {
    String phone;
    String nickname;
    String logo;
    LocalDateTime birthday;
    Integer sex;
    String email;
    LocalDateTime lastLoginTime;
    String username;
    String password;
    String salt;
}
