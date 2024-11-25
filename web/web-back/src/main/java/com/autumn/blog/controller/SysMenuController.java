package com.autumn.blog.controller;

import com.autumn.blog.common.annotation.LoginVerify;
import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.form.MenuAddForm;
import com.autumn.blog.model.vo.MenuPermissionVo;
import com.autumn.blog.model.vo.MenuTreeVo;
import com.autumn.blog.model.vo.MenuVo;
import com.autumn.blog.model.vo.SysMenuVo;
import com.autumn.blog.service.SysMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Slf4j
@Tag(name = "后台API接口管理")
@RestController
@RequestMapping("/system/menu")
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @LoginVerify
    @Operation(summary = "查询用户具有的菜单")
    @GetMapping("/getAuthMenuList")
    public Result<List<SysMenuVo>> getAuthMenuList() {
        List<SysMenuVo> menuList = sysMenuService.findMenuListByUserId();
        return Result.success(menuList);
    }

    @LoginVerify
    @Operation(summary = "菜单列表查询")
    @GetMapping("/getMenuList")
    public Result<List<SysMenuVo>> getMenuList() {
        return Result.success(sysMenuService.getMenuList());
    }

    @LoginVerify
    @Operation(summary = "添加")
    @PostMapping("/add")
    public Result<Boolean> addMenu(@RequestBody MenuAddForm menuAddForm) {
        return Result.success(sysMenuService.addMenu(menuAddForm));
    }

    @LoginVerify
    @Operation(summary = "获取详情")
    @GetMapping("/detail")
    public Result<MenuVo> detail(@RequestParam Long id) {
        return Result.success(sysMenuService.detail(id));
    }

    @LoginVerify
    @Operation(summary = "获取上级菜单树")
    @GetMapping("/tree")
    public Result<List<MenuTreeVo>> tree(@RequestParam(required = false) String nodeId) {
        return Result.success(sysMenuService.tree(nodeId));
    }

    @LoginVerify
    @Operation(summary = "获取按钮权限")
    @GetMapping("/getAuthButtonList")
    public Result<List<String>> getAuthButtonList() {
        return Result.success(sysMenuService.getAuthButtonList());
    }

    @LoginVerify
    @Operation(summary = "查询菜单按钮权限是否存在")
    @GetMapping("/btn/exists")
    public Result<MenuPermissionVo> findBtnPermission(@RequestParam(required = false) Long id, @RequestParam(required = false) String permission) {
        return Result.success(sysMenuService.findBtnPermission(id, permission));
    }

}
