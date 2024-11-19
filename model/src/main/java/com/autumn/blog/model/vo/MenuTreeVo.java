package com.autumn.blog.model.vo;

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
public class MenuTreeVo {
    @Schema(description = "id")
    private Object id;

    @Schema(description = "pid")
    private Object pid;

    @Schema(description = "层级")
    private Long deep;

    @Schema(description = "排序")
    private Long sort;

    @Schema(description = "title")
    private String title;

    @Schema(description = "菜单类型")
    private String menuTypeCd;

    @Schema(description = "按钮权限")
    private String permissions;

    @Schema(description = "子级")
    private List<MenuTreeVo> children;
}
