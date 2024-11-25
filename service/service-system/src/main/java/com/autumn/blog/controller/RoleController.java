package com.autumn.blog.controller;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.form.RoleForm;
import com.autumn.blog.model.form.RoleMenuForm;
import com.autumn.blog.model.vo.RoleMenuVo;
import com.autumn.blog.model.vo.RoleVo;
import com.autumn.blog.service.DictService;
import com.autumn.blog.service.RoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author autumn
 * @description DictController
 * @date 2024年11月19日
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/system/role")
@SuppressWarnings({"unchecked", "rawtypes"})
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/listPage")
    public Result<Page<RoleVo>> listPage(@RequestBody RoleForm form) {
        return Result.success(roleService.listPage(form));
    }

    @GetMapping("/getRoleMenus/{roleId}")
    public Result<RoleMenuVo> getRoleMenus(@PathVariable Long roleId) {
        return Result.success(roleService.getRoleMenus(roleId));
    }

    @PutMapping("/setRoleMenus")
    public Result<Boolean> setRoleMenus(@RequestBody RoleMenuForm form) {
        return Result.success(roleService.setRoleMenus(form));
    }



}
