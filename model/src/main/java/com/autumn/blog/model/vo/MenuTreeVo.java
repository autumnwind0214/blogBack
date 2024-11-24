package com.autumn.blog.model.vo;

import com.autumn.blog.common.base.TreeAble;
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
public class MenuTreeVo implements TreeAble<MenuTreeVo> {
    @Schema(description = "id")
    private Long id;

    @Schema(description = "pid")
    private Long pid;

    @Schema(description = "层级")
    private Long deep;

    @Schema(description = "排序")
    private Long sort;

    @Schema(description = "title")
    private String title;

    @Schema(description = "菜单类型")
    private String menuType;

    @Schema(description = "按钮权限")
    private String permissions;

    @Schema(description = "子级")
    private List<MenuTreeVo> children;
}
