package com.autumn.blog.controller;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.dto.LoginDto;
import com.autumn.blog.model.dto.UserInfoDto;
import com.autumn.blog.model.vo.LoginInfoVo;
import com.autumn.blog.model.vo.UserInfoVo;
import com.autumn.blog.service.UserInfoService;
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
@RequestMapping("/user")
@SuppressWarnings({"unchecked", "rawtypes"})
public class UserInfoController {

    // @Autowired
    // private UserInfoService userInfoService;
    //
    // @Operation(summary = "用户列表")
    // @PostMapping("/getUserList")
    // public Result<Page<UserInfoVo>> listPage(@RequestBody UserInfoDto form) {
    //     return Result.success(userInfoService.listPage(form));
    // }
    //
    // @GetMapping("/list")
    // public Result<Page<UserInfoVo>> list() {
    //     UserInfoDto form = new UserInfoDto();
    //     return Result.success(userInfoService.listPage(form));
    // }

}
