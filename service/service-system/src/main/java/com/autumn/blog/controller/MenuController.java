package com.autumn.blog.controller;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.form.MenuForm;
import com.autumn.blog.model.form.SelectIdsForm;
import com.autumn.blog.model.vo.MenuTreeVo;
import com.autumn.blog.model.vo.MenuVo;
import com.autumn.blog.model.vo.SysMenuVo;
import com.autumn.blog.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
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
@RestController
@RequestMapping("/system/menu")
@SuppressWarnings({"unchecked", "rawtypes"})
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Operation(summary = "查询用户具有的菜单")
    @GetMapping("/queryMenuByUserId/{userId}")
    public Result<List<SysMenuVo>> queryMenuByUserId(@PathVariable Long userId) {
        return Result.success(menuService.queryMenuByUserId(userId));
    }
    @Operation(summary = "获取按钮权限")
    @GetMapping("/getAuthButtonList/{userId}")
    public Result<List<String>> getAuthButtonList(@PathVariable Long userId) {
        return Result.success(menuService.getAuthButtonList(userId));
    }

    @Operation(summary = "列表查询")
    @GetMapping("/getMenuList")
    public Result<List<SysMenuVo>> getMenuList() {
        return Result.success(menuService.getMenuList());
    }

    @Operation(summary = "获取上级菜单树")
    @GetMapping("/queryParentListTree")
    public Result<List<MenuTreeVo>> queryParentListTree(@RequestParam(required = false) String nodeId) {
        return Result.success(menuService.queryParentListTree(nodeId));
    }

    @Operation(summary = "查询菜单按钮权限是否存在")
    @GetMapping("/findBtnPermission")
    public Result<Long> findBtnPermission(@RequestParam(required = false) Long id,
                                                      @RequestParam String permission) {
        return Result.success(menuService.findBtnPermission(id, permission));
    }

    @Operation(summary = "添加菜单")
    @PostMapping("/add")
    public Result<Boolean> addMenu(@RequestBody MenuForm menuForm) {
        return Result.success(menuService.addMenu(menuForm));
    }

    @GetMapping("/detail/{id}")
    public Result<MenuVo> detail(@PathVariable Long id) {
        return Result.success(menuService.detail(id));
    }

    @PutMapping("/edit")
    public Result<Boolean> edit(@RequestBody MenuForm menuForm) {
        return Result.success(menuService.edit(menuForm));
    }

    @DeleteMapping("/delete")
    public Result<Boolean> delete(@RequestBody SelectIdsForm ids) {
        return Result.success(menuService.delete(ids));
    }

}
