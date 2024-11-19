package com.autumn.blog.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "id")
    private Long id;

    @Schema(description = "pid")
    private Long pid;

    @Schema(description = "路径")
    private String path;

    private String name;

    private Integer sort;

    @JsonIgnore
    private String redirect;

    @Schema(description = "组件路径")
    private String component;

    @JsonIgnore
    private String icon;

    @JsonIgnore
    private String title;

    @JsonIgnore
    private Byte hasHidden;

    @JsonIgnore
    private Byte hasFull;

    @JsonIgnore
    private Byte hasAffix;

    @JsonIgnore
    private String useDataScope;

    @JsonIgnore
    private Byte hasKeepAlive;

    @Schema(description = "元数据")
    private Meta meta;

    private List<SysMenuVo> children;

    @Schema(description = "权限标识")
    private String permissions;

    @Schema(description = "菜单类型")
    private Integer menuType;

    @Data
    public static class Meta {

        @Schema(description = "菜单和面包屑对应的图标")
        private String icon;

        @Schema(description = "路由标题 (用作 document.title || 菜单的名称)")
        private String title;

        @Schema(description = "是否在菜单中隐藏 (通常列表详情页需要隐藏)")
        private Byte hasHidden;

        @Schema(description = "菜单是否全屏 (示例：数据大屏页面)")
        private Byte hasFull;

        @Schema(description = "菜单是否固定在标签页中")
        private Byte hasAffix;

        @Schema(description = "当前路由是否缓存")
        private Byte hasKeepAlive;

        @Schema(description = "菜单是否开启数据权限")
        private String useDataScope;
    }
}