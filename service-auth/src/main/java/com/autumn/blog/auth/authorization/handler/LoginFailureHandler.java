package com.autumn.blog.auth.authorization.handler;

import com.alibaba.fastjson2.JSONObject;
import com.autumn.blog.common.result.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author autumn
 * @description 登录失败处理类
 * @date 2024年12月27日
 * @version: 1.0
 */
@Slf4j
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        log.debug("登录失败，原因：{}", exception.getMessage());
        // 登录失败，写回401与具体的异常
        Result<String> fail = Result.fail(exception.getMessage());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(JSONObject.toJSONString(fail));
        response.getWriter().flush();
    }

}
