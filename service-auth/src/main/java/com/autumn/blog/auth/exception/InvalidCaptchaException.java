package com.autumn.blog.auth.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author autumn
 * @description 验证码异常类
 * @date 2024年12月25日
 * @version: 1.0
 */
public class InvalidCaptchaException extends AuthenticationException {
    public InvalidCaptchaException(String msg) {
        super(msg);
    }
}
