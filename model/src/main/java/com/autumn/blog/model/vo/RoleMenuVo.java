package com.autumn.blog.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author autumn
 * @description 角色菜单详情
 * @date 2024年11月25日
 * @version: 1.0
 */
@Data
public class RoleMenuVo implements Serializable {

    private static final long serialVersionUID = 1L;

    // 菜单列表
    private List<MenuTreeVo> menuLists;

    // 选中的菜单id
    @JsonSerialize(contentUsing = ToStringSerializer.class)
    private List<Long> selectIds = new ArrayList<>();
}
