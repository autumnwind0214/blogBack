package com.autumn.blog.auth.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;

import com.autumn.blog.common.config.RedisOperator;
import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.vo.CaptchaVo;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.autumn.blog.common.constant.RedisConstant.*;


/**
 * @author autumn
 * @description 登录接口，登录使用的接口
 * @date 2024年12月26日
 * @version: 1.0
 */
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final RedisOperator<String> redisOperator;

    @GetMapping("/getSmsCaptcha")
    public Result<String> getSmsCaptcha(String phone) {
        // 示例项目，固定1234
        String smsCaptcha = "1234";
        // 存入缓存中，5分钟后过期
        redisOperator.set((SMS_CAPTCHA_PREFIX_KEY + phone), smsCaptcha, DEFAULT_TIMEOUT_SECONDS);
        return Result.success(smsCaptcha);
    }

    @GetMapping("/getCaptcha")
    public Result<CaptchaVo> getCaptcha() {
        // 使用huTool-captcha生成图形验证码
        // 定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(130, 34, 4, 2);
        // 生成一个唯一id
        long id = IdWorker.getId();
        // 存入缓存中，5分钟后过期
        redisOperator.set((IMAGE_CAPTCHA_PREFIX_KEY + id), captcha.getCode(), DEFAULT_TIMEOUT_SECONDS);
        CaptchaVo vo = new CaptchaVo(String.valueOf(id), captcha.getCode(), captcha.getImageBase64Data());
        return Result.success(vo);
    }

}
