package com.autumn.blog.controller;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.dto.MenuDto;
import com.autumn.blog.model.dto.SelectIdsDto;
import com.autumn.blog.model.vo.MenuTreeVo;
import com.autumn.blog.model.vo.MenuVo;
import com.autumn.blog.model.vo.SysMenuVo;
import com.autumn.blog.service.MenuService;
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
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // 查询用户具有的菜单
    @GetMapping("/getAsyncRoutes/{userId}")
    public List<SysMenuVo> getAsyncRoutes(@PathVariable Long userId) {
        return menuService.getAsyncRoutes(userId);
    }
    // 获取按钮权限
    @GetMapping("/getAuthButtonList/{userId}")
    public Result<List<String>> getAuthButtonList(@PathVariable Long userId) {
        return Result.success(menuService.getAuthButtonList(userId));
    }

    // 列表查询
    @GetMapping("/getMenuList")
    public Result<List<SysMenuVo>> getMenuList() {
        return Result.success(menuService.getMenuList());
    }

    // 获取上级菜单树
    @GetMapping("/queryParentListTree")
    public Result<List<MenuTreeVo>> queryParentListTree(@RequestParam(required = false) String nodeId) {
        return Result.success(menuService.queryParentListTree(nodeId));
    }

    // 查询菜单按钮权限是否存在
    @GetMapping("/findBtnPermission")
    public Result<Long> findBtnPermission(@RequestParam(required = false) Long id,
                                                      @RequestParam String permission) {
        return Result.success(menuService.findBtnPermission(id, permission));
    }

    // 添加菜单
    @PostMapping("/add")
    public Result<Boolean> addMenu(@RequestBody MenuDto menuDto) {
        return Result.success(menuService.addMenu(menuDto));
    }

    @GetMapping("/detail/{id}")
    public Result<MenuVo> detail(@PathVariable Long id) {
        return Result.success(menuService.detail(id));
    }

    @PutMapping("/edit")
    public Result<Boolean> edit(@RequestBody MenuDto menuDto) {
        return Result.success(menuService.edit(menuDto));
    }

    @DeleteMapping("/delete")
    public Result<Boolean> delete(@RequestBody SelectIdsDto ids) {
        return Result.success(menuService.delete(ids));
    }

}
