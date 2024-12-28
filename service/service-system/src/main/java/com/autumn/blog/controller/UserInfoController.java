package com.autumn.blog.controller;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.dto.UserInfoDto;
import com.autumn.blog.model.po.system.UserInfo;
import com.autumn.blog.model.vo.UserInfoVo;
import com.autumn.blog.service.UserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author autumn
 * @description
 * @date 2024年11月14日
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/userinfo")
@SuppressWarnings({"unchecked", "rawtypes"})
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    // 用户列表
    @PostMapping("/listPage")
    public Result<Page<UserInfoVo>> listPage(@RequestBody UserInfoDto form) {
        return Result.success(userInfoService.listPage(form));
    }

    @GetMapping("/getUserInfoByUserName/{username}")
    public Result<UserInfo> getUserInfoByUserName(@PathVariable String username) {
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserInfo::getUsername, username);
        return Result.success(userInfoService.getOne(wrapper));
    }
}
