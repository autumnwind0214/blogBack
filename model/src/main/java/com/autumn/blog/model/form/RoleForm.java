package com.autumn.blog.model.form;

import com.autumn.blog.common.base.PageQuery;
import lombok.Data;

/**
 * @author autumn
 * @description RoleForm
 * @date 2024年11月25日
 * @version: 1.0
 */
@Data
public class RoleForm extends PageQuery {
    // 角色名称
    private String roleName;

    // 角色标识
    private String permission;
}
