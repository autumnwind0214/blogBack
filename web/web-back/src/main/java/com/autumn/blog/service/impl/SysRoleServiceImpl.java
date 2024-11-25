package com.autumn.blog.service.impl;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.form.RoleForm;
import com.autumn.blog.model.vo.RoleVo;
import com.autumn.blog.service.SysRoleService;
import com.autumn.blog.system.client.SysRoleFeignClient;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleFeignClient roleFeignClient;

    @Override
    public Page<RoleVo> listPage(RoleForm form) {
        Result<Page<RoleVo>> result = roleFeignClient.listPage(form);
        return result.getData();
    }
}
