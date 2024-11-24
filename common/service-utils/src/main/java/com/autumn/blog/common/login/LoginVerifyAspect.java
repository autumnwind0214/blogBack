package com.autumn.blog.common.login;

import com.autumn.blog.common.constant.RedisConstant;
import com.autumn.blog.common.exception.AutumnException;
import com.autumn.blog.common.result.ResultCodeEnum;
import com.autumn.blog.common.util.AuthContextHolder;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Component
@Aspect // 切面类
public class LoginVerifyAspect {

    @Autowired
    private RedisTemplate redisTemplate;

    // 环绕通知，登录判断
    // 切入点表达式：指定对哪些规则的方法进行增强
    @Around("execution(* com.autumn.blog..controller.*.*(..)) && @annotation(loginVerify)")
    public Object login(ProceedingJoinPoint joinPoint, LoginVerify loginVerify) throws Throwable {
        // 1.获取request对象
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();

        // 2.从请求头中获取token
        String token = request.getHeader("Authorization");

        // 3.判断token是否为空，如果为空，返回登录提示
        if (!StringUtils.hasText(token)) {
            throw new AutumnException(ResultCodeEnum.UNAUTHORIZED, "未登录");
        }

        // 4.token不为空，查询
        String userId = (String) redisTemplate.opsForValue().get(RedisConstant.USER_LOGIN_KEY_PREFIX + token);

        // 5.查询redis对应用户id，把用户id放到ThreadLocal中
        if (StringUtils.hasText(userId)) {
            AuthContextHolder.setUserId(Long.parseLong(userId));
        } else {
            throw new AutumnException(ResultCodeEnum.UNAUTHORIZED, "授权过期");
        }
        // 6.执行业务方法
        return joinPoint.proceed();
    }
}
