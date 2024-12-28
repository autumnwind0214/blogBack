package com.autumn.blog.mapper;

import com.autumn.blog.model.po.system.Role;
import com.autumn.blog.model.dto.RoleDto;
import com.autumn.blog.model.vo.RoleVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author autumn
 * @description RoleMapper
 * @date 2024年11月15日
 * @version: 1.0
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    Page<RoleVo> listPage(@Param("page") Page<RoleVo> page, @Param("query") RoleDto form);
}
