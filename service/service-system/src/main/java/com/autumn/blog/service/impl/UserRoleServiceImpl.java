package com.autumn.blog.service.impl;

import com.autumn.blog.mapper.UserRoleMapper;
import com.autumn.blog.model.po.system.UserRole;
import com.autumn.blog.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author autumn
 * @description UserRoleServiceImpl
 * @date 2024年11月15日
 * @version: 1.0
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
