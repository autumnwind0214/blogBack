package com.autumn.blog.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Data
public class SysMenuVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long pid;

    // 路径
    private String path;

    private String name;

    private Integer sort;

    @JsonIgnore
    private String redirect;

    // 组件路径
    private String component;

    @JsonIgnore
    private String icon;

    @JsonIgnore
    private String title;

    @JsonIgnore
    private Byte isHidden;

    @JsonIgnore
    private Byte isFull;

    @JsonIgnore
    private Byte isAffix;

    @JsonIgnore
    private String useDataScope;

    @JsonIgnore
    private Byte isKeepAlive;

    // 元数据
    private Meta meta;

    private List<SysMenuVo> children;

    // 权限标识
    private String permission;

    // 菜单类型
    private Integer menuType;

    @Data
    public static class Meta {

        // 菜单和面包屑对应的图标
        private String icon;

        // 路由标题 (用作 document.title || 菜单的名称)
        private String title;

        // 是否在菜单中隐藏 (通常列表详情页需要隐藏)
        private Byte isHidden;

        // 菜单是否全屏 (示例：数据大屏页面)
        private Byte isFull;

        // 菜单是否固定在标签页中
        private Byte isAffix;

        // 当前路由是否缓存
        private Byte isKeepAlive;

        // 菜单是否开启数据权限
        private String useDataScope;
    }
}
