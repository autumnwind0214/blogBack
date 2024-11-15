package com.autumn.blog.service.impl;

import com.autumn.blog.common.constant.RedisConstant;
import com.autumn.blog.common.exception.AutumnException;
import com.autumn.blog.common.result.Result;
import com.autumn.blog.common.result.ResultCodeEnum;
import com.autumn.blog.common.util.AuthContextHolder;
import com.autumn.blog.common.util.UuidUtils;
import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.form.RegisterForm;
import com.autumn.blog.model.vo.LoginInfoVo;
import com.autumn.blog.model.vo.UserInfoVo;
import com.autumn.blog.service.UserInfoService;
import com.autumn.blog.user.client.UserInfoFeignClient;
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
        if (!ResultCodeEnum.SUCCESS.getCode().equals(code)) {
            new AutumnException(ResultCodeEnum.ACCOUNT_ERROR);
        }
        UserInfoVo vo = result.getData();
        if (vo == null) {
            throw new AutumnException(ResultCodeEnum.DATA_ERROR);
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
}
