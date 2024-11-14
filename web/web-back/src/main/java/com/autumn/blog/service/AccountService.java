package com.autumn.blog.service;

import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.vo.UserVo;

/**
 * @author autumn
 * @description
 * @date 2024年11月10日
 * @version: 1.0
 */
public interface AccountService {

    UserVo login(LoginForm loginForm);
}
