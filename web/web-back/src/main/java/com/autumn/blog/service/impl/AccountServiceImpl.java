package com.autumn.blog.service.impl;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.vo.UserVo;
import com.autumn.blog.service.AccountService;
import com.autumn.blog.user.client.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author autumn
 * @description
 * @date 2024年11月10日
 * @version: 1.0
 */
@Slf4j
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public UserVo login(LoginForm loginForm) {
        Result<UserVo> result = userFeignClient.login(loginForm);
        return result.getData();
    }
}
