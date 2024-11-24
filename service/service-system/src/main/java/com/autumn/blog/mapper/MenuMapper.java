package com.autumn.blog.mapper;

import com.autumn.blog.model.entity.system.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    // 更新deep
    void syncTreeDeep();

    // 更新has_children
    void syncTreeHasChildren();
}
