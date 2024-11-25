package com.autumn.blog.controller;

import com.autumn.blog.common.annotation.LoginVerify;
import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.form.RoleForm;
import com.autumn.blog.model.form.RoleMenuForm;
import com.autumn.blog.model.vo.RoleMenuVo;
import com.autumn.blog.model.vo.RoleVo;
import com.autumn.blog.service.SysRoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Slf4j
@Tag(name = "后台API接口管理")
@RestController
@RequestMapping("/system/role")
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @LoginVerify
    @Operation(summary = "获取角色列表")
    @PostMapping("/getRoleList")
    public Result<Page<RoleVo>> getRoleList(@RequestBody RoleForm form) {
        return Result.success(sysRoleService.listPage(form));
    }

    // @LoginVerify
    @Operation(summary = "获取角色菜单权限")
    @GetMapping("/getRoleMenus")
    public Result<RoleMenuVo> getRoleMenus(@RequestParam Long roleId) {
        return Result.success(sysRoleService.getRoleMenus(roleId));
    }

    @LoginVerify
    @Operation(summary = "设置角色菜单权限")
    @PutMapping("/setRoleMenus")
    public Result<Boolean> setRoleMenus(@RequestBody RoleMenuForm form) {
        return Result.success(sysRoleService.setRoleMenus(form));
    }

}
