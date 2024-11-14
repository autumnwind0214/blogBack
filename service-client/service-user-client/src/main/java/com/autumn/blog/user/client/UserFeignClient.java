package com.autumn.blog.user.client;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author autumn
 * @description 远程调用
 * @date 2024年11月10日
 * @version: 1.0
 */
@FeignClient(value = "service-user")
public interface UserFeignClient {

    @PostMapping("/account/info/login")
    public Result<UserVo> login(@RequestBody LoginForm loginForm);
}
