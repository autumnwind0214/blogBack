package com.autumn.blog.model.entity.system;

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
    // 组件路径
    String component;
    // 排序
    Integer sort;
    // 层级
    Integer deep;
    // 按钮权限
    String permission;
    // 是否隐藏
    Byte isHidden;
    // 是否有子级
    Byte hasChildren;
    // 是否全屏
    Byte isFull;
    // 菜单是否固定在标签页
    Byte isAffix;
    // 当前路由是否缓存
    Byte isKeepAlive;
    // 是否有外链
    Byte isLink;
    // 外链地址
    String redirect;
    // 菜单类型
    Integer menuType;
}
