package com.autumn.blog.service.impl;

import com.autumn.blog.mapper.RoleMapper;
import com.autumn.blog.model.entity.system.Role;
import com.autumn.blog.model.form.RoleForm;
import com.autumn.blog.model.vo.RoleVo;
import com.autumn.blog.service.RoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author autumn
 * @description RoleServiceImpl
 * @date 2024年11月15日
 * @version: 1.0
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Page<RoleVo> listPage(RoleForm form) {
        Page<RoleVo> page = new Page<>(form.getPage(), form.getSize());
        return roleMapper.listPage(page, form);
    }
}
