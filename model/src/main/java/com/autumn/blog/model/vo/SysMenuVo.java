package com.autumn.blog.model.vo;

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

    // 路由名称
    private String name;

    // 标题
    private String title;

    //图标
    private String icon;

    // 排序
    private Integer sort;

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

        // 排序
        private Integer sort;
    }
}
