package com.autumn.blog.service;

import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.form.RegisterForm;
import com.autumn.blog.model.form.UserInfoForm;
import com.autumn.blog.model.vo.UserInfoVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
public interface UserInfoService {

    UserInfoVo login(LoginForm loginForm);

    Boolean register(RegisterForm registerForm);

    Page<UserInfoVo> listPage(UserInfoForm form);
}
