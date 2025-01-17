package com.autumn.blog.model.dto;


import lombok.Data;

import java.util.List;

/**
 * @author autumn
 * @description 角色菜单变更
 * @date 2024年11月25日
 * @version: 1.0
 */
@Data
public class RoleMenuDto {

    // 菜单id数组
    List<Long> menuIds;

    Long roleId;
}
