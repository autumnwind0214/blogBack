package com.autumn.blog.common.exception;

import com.autumn.blog.common.result.Result;

/**
 * @author autumn
 * @description 抽象异常处理机制
 * @date 2025年01月03日
 * @version: 1.0
 */
public interface CustomExceptionResolver {

    boolean supports(Throwable exception);

    Result<String> resolve(Throwable exception);
}
