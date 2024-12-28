package com.autumn.blog.model.dto;

import lombok.Data;

/**
 * @author autumn
 * @description 菜单权限查询
 * @date 2024年11月20日
 * @version: 1.0
 */
@Data
public class MenuPermissionDto {
    // 菜单id
    private Long id;

    //权限标识
    private String permission;
}
