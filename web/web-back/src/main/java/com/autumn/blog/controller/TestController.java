package com.autumn.blog.controller;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.resource.annotation.AuthenticationUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 测试接口
 *
 * @author vains
 */
@RestController
public class TestController {

    @GetMapping("/test01")
    @PreAuthorize("hasAnyAuthority('message.write')")
    public Mono<String> test01() {
        return Mono.just("test01");
    }

    @GetMapping("/test02")
    @PreAuthorize("hasAnyAuthority('test02')")
    public Mono<String> test02() {
        return Mono.just("test02");
    }

    @AuthenticationUser
    @GetMapping("/app")
    @PreAuthorize("hasAuthority('test')")
    public Mono<Result<String>> app(@RequestAttribute("userId") Long userId) {
        return Mono.just(Result.success(userId.toString()));
    }

    @GetMapping("/test")
    @PreAuthorize("hasAnyAuthority('test')")
    public Mono<Result<String>> test() {
        return Mono.just(Result.success("test"));
    }

}
