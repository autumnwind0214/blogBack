package com.autumn.blog.model.entity;

import com.autumn.blog.common.base.BaseEntity;
import lombok.Data;

/**
 * @author autumn
 * @description 角色
 * @date 2024年11月14日
 * @version: 1.0
 */
@Data
public class Role extends BaseEntity {
    String roleName;
    Byte isLock;
    String permission;
}
