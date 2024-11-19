package com.autumn.blog.controller;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.vo.SysMenuVo;
import com.autumn.blog.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Operation(summary = "列表查询")
    @GetMapping("/getMenuList")
    public Result<List<SysMenuVo>> getMenuList() {
        return Result.success(menuService.getMenuList());
    }

}
