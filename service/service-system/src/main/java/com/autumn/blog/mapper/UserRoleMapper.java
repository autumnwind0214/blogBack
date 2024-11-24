package com.autumn.blog.mapper;

import com.autumn.blog.model.entity.system.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author autumn
 * @description UserRoleMapper
 * @date 2024年11月15日
 * @version: 1.0
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<String> queryMenuIdByUserId(@Param("userId")Long userId);

    List<String> queryPermissionByUserId(@Param("userId")Long userId);
}
