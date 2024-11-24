package com.autumn.blog.service;

import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.form.RegisterForm;
import com.autumn.blog.model.form.UserInfoForm;
import com.autumn.blog.model.vo.LoginInfoVo;
import com.autumn.blog.model.vo.UserInfoVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
public interface UserInfoService {
    LoginInfoVo login(LoginForm loginForm);

    Boolean register(RegisterForm registerForm);

    Boolean logout(String token);

    Page<UserInfoVo> listPage(UserInfoForm form);
}
