package com.autumn.blog.resource.exception;

import com.autumn.blog.common.exception.CustomExceptionResolver;
import com.autumn.blog.common.result.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

/**
 * @author autumn
 * @description 权限不足异常
 * @date 2025年01月03日
 * @version: 1.0
 */
@Component
public class AccessDeniedExceptionResolver implements CustomExceptionResolver {

    @Override
    public boolean supports(Throwable exception) {
        // 判断异常是否为 AccessDeniedException
        return exception instanceof AccessDeniedException;
    }

    @Override
    public Result<String> resolve(Throwable exception) {
        return Result.fail("权限不足");
    }
}
