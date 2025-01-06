package com.autumn.blog.auth.mapper;

import com.autumn.blog.model.po.auth.AuthorizationUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorizationUserMapper extends BaseMapper<AuthorizationUser> {
}
