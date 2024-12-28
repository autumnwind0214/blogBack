package com.autumn.blog.model.dto;

import com.autumn.blog.model.base.PageQuery;
import lombok.Data;

/**
 * @author autumn
 * @description RoleDto
 * @date 2024年11月25日
 * @version: 1.0
 */
@Data
public class RoleDto extends PageQuery {
    // 角色名称
    private String roleName;

    // 角色标识
    private String permission;
}
