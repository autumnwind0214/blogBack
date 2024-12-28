package com.autumn.blog.model.dto;

import lombok.Data;

/**
 * @author autumn
 * @description 菜单添加表单
 * @date 2024年11月20日
 * @version: 1.0
 */
@Data
public class MenuDto {

    // 菜单id（修改菜单时必填）
    private Long id;

    private String title;

    /**
     * 父级id
     */
    private Long pid;

    /**
     * 路径
     */
    private String path;

    private String name;

    /**
     * icon图标
     */
    private String icon;

    /**
     * 组件路径
     */
    private String component;

    /**
     * redirect地址
     */
    private String redirect;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 层级
     */
    private Integer deep;

    /**
     * 菜单类型 （字典表menu_type）
     */
    private Integer menuType;

    /**
     * 按钮权限
     */
    private String permission;

    /**
     * 是否隐藏
     */
    private Byte isHidden;

    /**
     * 是否有子级
     */
    private Byte hasChildren;

    /**
     * 路由外链时填写的访问地址
     */
    private Byte isLink;

    /**
     * 菜单是否全屏
     */
    private Byte isFull;

    /**
     * 菜单是否固定在标签页
     */
    private Byte isAffix;

    /**
     * 当前路由是否缓存
     */
    private Byte isKeepAlive;
}
