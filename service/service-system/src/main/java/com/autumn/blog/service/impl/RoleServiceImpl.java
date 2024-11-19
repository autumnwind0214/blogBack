package com.autumn.blog.service.impl;

import com.autumn.blog.mapper.RoleMapper;
import com.autumn.blog.model.entity.system.Role;
import com.autumn.blog.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author autumn
 * @description RoleServiceImpl
 * @date 2024年11月15日
 * @version: 1.0
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
