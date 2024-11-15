package com.autumn.blog.controller;

import com.autumn.blog.common.login.LoginVerify;
import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.form.RegisterForm;
import com.autumn.blog.model.vo.LoginInfoVo;
import com.autumn.blog.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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

    @Autowired
    private UserInfoService userInfoService;

    @Operation(summary = "登录")
    @PostMapping("/login")
    public Result<LoginInfoVo> login(@RequestBody LoginForm loginForm) {
        return Result.success(userInfoService.login(loginForm));
    }

    @Operation(summary = "注册")
    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody RegisterForm registerForm) {
        return Result.success(userInfoService.register(registerForm));
    }

    @Operation(summary = "退出登录")
    @PostMapping("/logout")
    public Result<Boolean> logout(@RequestHeader("Authorization") String token) {
        return Result.success(userInfoService.logout(token));
    }

}
