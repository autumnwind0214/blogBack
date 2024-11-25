package com.autumn.blog.model.vo;

import com.autumn.blog.common.base.TreeAble;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Data
public class MenuTreeVo implements TreeAble<MenuTreeVo>, Serializable {
    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long pid;

    @Schema(description = "层级")
    private Integer deep;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "title")
    private String title;

    @Schema(description = "菜单类型")
    private Integer menuType;

    @Schema(description = "按钮权限")
    private String permissions;

    @Schema(description = "子级")
    private List<MenuTreeVo> children;
}
