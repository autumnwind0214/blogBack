package com.autumn.blog.mapper;

import com.autumn.blog.model.dto.UserInfoDto;
import com.autumn.blog.model.po.system.UserInfo;
import com.autumn.blog.model.vo.UserInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    Page<UserInfoVo> listPage(@Param("page") Page<UserInfoVo> page, @Param("query") UserInfoDto form);
}
