package com.autumn.blog.model.entity;

import com.autumn.blog.common.base.BaseEntity;
import lombok.Data;

/**
 * @author autumn
 * @description 菜单
 * @date 2024年11月14日
 * @version: 1.0
 */
@Data
public class Menu extends BaseEntity {
    Long pid;
    String path;
    String name;
    String title;
    String icon;
    String component;
    Integer sort;
    Integer deep;
    String permission;
    Byte hasHidden;
    Byte hasChildren;
    Byte hasFull;
    Byte hasAffix;
    Byte hasKeepAlive;
}
