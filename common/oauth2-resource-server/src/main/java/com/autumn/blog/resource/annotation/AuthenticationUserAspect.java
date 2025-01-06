package com.autumn.blog.resource.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author autumn
 * @description 定义切面获取用户信息
 * @date 2025年01月03日
 * @version: 1.0
 */
@Aspect
@Component
public class AuthenticationUserAspect {

    // @Before("@annotation(AuthenticationUser)")
    // public void injectJwt() {
    //     // 从 SecurityContext 中获取用户信息
    //     ReactiveSecurityContextHolder.getContext()
    //             .map(context -> context.getAuthentication())
    //             .filter(auth -> auth.getPrincipal() instanceof Jwt)
    //             .map(auth -> {
    //                 Jwt jwt = (Jwt) auth.getPrincipal();
    //                 String userId = jwt.getClaimAsString("sub");
    //                 // String username = jwt.getClaimAsString("preferred_username");
    //                 // List<String> roles = jwt.getClaimAsStringList("roles");
    //                 AuthContextHolder.setUser(Long.valueOf(userId));
    //                 // 存入 ThreadLocal
    //                 return Mono.empty();
    //             })
    //             .subscribe();
    // }
}
