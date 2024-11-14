package com.autumn.blog.controller;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.common.util.AuthContextHolder;
import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.form.RegisterForm;
import com.autumn.blog.model.vo.UserVo;
import com.autumn.blog.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author autumn
 * @description
 * @date 2024年11月10日
 * @version: 1.0
 */
@Slf4j
@Tag(name = "后台API接口管理")
@RestController
@RequestMapping("/account")
@SuppressWarnings({"unchecked", "rawtypes"})
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Operation(summary = "后台登录接口")
    @PostMapping("/login")
    public Result<UserVo> login(@RequestBody LoginForm loginForm) {
        return Result.success(accountService.login(loginForm));
    }

    @Operation(summary = "后台注册接口")
    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody RegisterForm registerForm) {
        return Result.success(accountService.register(registerForm));
    }
}
