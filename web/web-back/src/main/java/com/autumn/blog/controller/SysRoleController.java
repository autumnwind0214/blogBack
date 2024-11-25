package com.autumn.blog.controller;

import com.autumn.blog.common.login.LoginVerify;
import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.form.RoleForm;
import com.autumn.blog.model.vo.RoleVo;
import com.autumn.blog.model.vo.SysDictVo;
import com.autumn.blog.service.SysDictService;
import com.autumn.blog.service.SysRoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @Operation(summary = "获取所有字典信息")
    @PostMapping("/getRoleList")
    public Result<Page<RoleVo>> getRoleList(@RequestBody RoleForm form) {
        return Result.success(sysRoleService.listPage(form));
    }

}
