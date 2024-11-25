package com.autumn.blog.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author autumn
 * @description RoleVo
 * @date 2024年11月25日
 * @version: 1.0
 */
@Data
public class RoleVo {
    Long id;
    String roleName;
    String permission;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
