package com.autumn.blog.model.po.system;

import com.autumn.blog.model.base.BaseEntity;
import lombok.Data;

/**
 * @author autumn
 * @description 菜单
 * @date 2024年11月14日
 * @version: 1.0
 */
@Data
public class Menu extends BaseEntity {
    // 父级id
    Long pid;
    // 路径
    String path;
    // 路由名称
    String name;
    // 标题
    String title;
    // 图标
    String icon;
    // 排序
    Integer sort;
    // 层级
    Integer deep;
    // 按钮权限
    String permission;
    // 是否有子级
    Byte hasChildren;
    // 菜单类型
    Integer menuType;
}
