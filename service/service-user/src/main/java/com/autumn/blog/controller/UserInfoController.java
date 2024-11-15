package com.autumn.blog.controller;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.form.RegisterForm;
import com.autumn.blog.model.vo.UserInfoVo;
import com.autumn.blog.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/user/info")
@SuppressWarnings({"unchecked", "rawtypes"})
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Operation(summary = "登录")
    @PostMapping("/login")
    public Result<UserInfoVo> login(@RequestBody LoginForm loginForm) {
        UserInfoVo vo = userInfoService.login(loginForm);
        return Result.success(vo);
    }

    @Operation(summary = "注册")
    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody RegisterForm registerForm) {
        return Result.success(userInfoService.register(registerForm));
    }

}