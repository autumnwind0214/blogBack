package com.autumn.blog.service.impl;

import com.autumn.blog.common.constant.RedisConstant;
import com.autumn.blog.common.exception.AutumnException;
import com.autumn.blog.common.result.Result;
import com.autumn.blog.common.result.ResultCodeEnum;
import com.autumn.blog.common.util.UuidUtils;
import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.form.RegisterForm;
import com.autumn.blog.model.form.UserInfoForm;
import com.autumn.blog.model.vo.LoginInfoVo;
import com.autumn.blog.model.vo.UserInfoVo;
import com.autumn.blog.service.UserInfoService;
import com.autumn.blog.system.client.UserInfoFeignClient;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;


    @Override
    public LoginInfoVo login(LoginForm loginForm) {
        Result<UserInfoVo> result = userInfoFeignClient.login(loginForm);
        // 1.判断返回状态值
        Integer code = result.getCode();
        if (!ResultCodeEnum.isOk(code)) {
            new AutumnException(ResultCodeEnum.BAD_REQUEST);
        }
        UserInfoVo vo = result.getData();
        if (vo == null) {
            throw new AutumnException(ResultCodeEnum.NOT_FOUND, "用户不存在");
        }

        // 2.生成token字符串
        String token = UuidUtils.getUUID();
        // 把用户id放到redis，设置过期时间
        redisTemplate.opsForValue().set(RedisConstant.USER_LOGIN_KEY_PREFIX + token,
                vo.getId().toString(),
                RedisConstant.USER_LOGIN_KEY_TIMEOUT,
                TimeUnit.SECONDS);
        LoginInfoVo loginInfoVo = new LoginInfoVo();
        loginInfoVo.setUserInfo(vo);
        loginInfoVo.setName(StringUtils.hasText(vo.getNickname()) ? vo.getNickname() : vo.getUsername());
        loginInfoVo.setAccessToken(token);
        return loginInfoVo;
    }

    @Override
    public Boolean register(RegisterForm registerForm) {
        Result<Boolean> result = userInfoFeignClient.register(registerForm);
        return result.getData();
    }

    @Override
    public Boolean logout(String token) {
        Boolean delete = redisTemplate.delete(RedisConstant.USER_LOGIN_KEY_PREFIX + token);
        return true;
    }

    @Override
    public Page<UserInfoVo> listPage(UserInfoForm form) {
        Result<Page<UserInfoVo>> result = userInfoFeignClient.listPage(form);
        return result.getData();
    }
}
