package com.autumn.blog.service;

import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.form.RegisterForm;
import com.autumn.blog.model.vo.UserVo;

/**
 * @author autumn
 * @description
 * @date 2024年11月11日
 * @version: 1.0
 */
public interface AccountService {
    // 登录
    UserVo login(LoginForm loginForm);

    // 注册
    Boolean register(RegisterForm registerForm);
}
