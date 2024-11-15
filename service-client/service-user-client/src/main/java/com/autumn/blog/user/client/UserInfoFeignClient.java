package com.autumn.blog.user.client;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.form.RegisterForm;
import com.autumn.blog.model.vo.UserInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author autumn
 * @description 远程调用
 * @date 2024年11月15日
 * @version: 1.0
 */
@FeignClient(value = "service-user")
public interface UserInfoFeignClient {

    // 用户登录
    @PostMapping("/user/info/login")
    public Result<UserInfoVo> login(@RequestBody LoginForm loginForm);

    // 用户注册
    @PostMapping("/user/info/register")
    public Result<Boolean> register(@RequestBody RegisterForm registerForm);
}
