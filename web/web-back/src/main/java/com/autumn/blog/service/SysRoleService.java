package com.autumn.blog.service;

import com.autumn.blog.model.form.RoleForm;
import com.autumn.blog.model.vo.RoleVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
public interface SysRoleService {

    Page<RoleVo> listPage(RoleForm form);
}
