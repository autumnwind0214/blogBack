package com.autumn.blog.controller;

import com.autumn.blog.common.login.LoginVerify;
import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.entity.system.Dict;
import com.autumn.blog.model.vo.SysDictVo;
import com.autumn.blog.model.vo.SysMenuVo;
import com.autumn.blog.service.SystemAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/system")
@SuppressWarnings({"unchecked", "rawtypes"})
public class SystemAuthController {

    @Autowired
    private SystemAuthService systemAuthService;

    @LoginVerify
    @Operation(summary = "查询用户具有的菜单")
    @GetMapping("/menu")
    public Result<List<SysMenuVo>> queryMenuByUserId() {
        List<SysMenuVo> menuList = systemAuthService.findMenuListByUserId();
        return Result.success(menuList);
    }

    @LoginVerify
    @Operation(summary = "菜单列表查询")
    @GetMapping("/menu/getMenuList")
    public Result<List<SysMenuVo>> getMenuList() {
        return Result.success(systemAuthService.getMenuList());
    }

    @LoginVerify
    @Operation(summary = "获取所有字典信息")
    @GetMapping("/dict/getAllDict")
    public Result<Map<String, List<SysDictVo>>> getAllDict() {
        return Result.success(systemAuthService.getAllDict());
    }
}
