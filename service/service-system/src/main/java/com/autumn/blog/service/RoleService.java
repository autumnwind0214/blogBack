package com.autumn.blog.service;

import com.autumn.blog.model.entity.system.Role;
import com.autumn.blog.model.form.RoleForm;
import com.autumn.blog.model.form.RoleMenuForm;
import com.autumn.blog.model.vo.RoleMenuVo;
import com.autumn.blog.model.vo.RoleVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author autumn
 * @description RoleService
 * @date 2024年11月15日
 * @version: 1.0
 */
public interface RoleService extends IService<Role> {
    Page<RoleVo> listPage(RoleForm form);

    RoleMenuVo getRoleMenus(Long roleId);

    Boolean setRoleMenus(RoleMenuForm form);
}
