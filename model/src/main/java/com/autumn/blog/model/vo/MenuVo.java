package com.autumn.blog.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author autumn
 * @description 菜单详情
 * @date 2024年11月26日
 * @version: 1.0
 */
@Data
public class MenuVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long pid;

    private String path;

    private String name;

    private String title;

    private String icon;

    private String component;

    private String redirect;

    private Integer sort;

    private Integer deep;

    private Integer menuType;

    private String permission;

    private Byte isHidden;

    private Byte hasChildren;

    private Byte isLink;

    private Byte isFull;

    private Byte isAffix;

    private Byte isKeepAlive;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
