package com.autumn.blog.resource.annotation;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @author autumn
 * @description
 * @date 2025年01月06日
 * @version: 1.0
 */
@Component
public class UserContextFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return ReactiveSecurityContextHolder.getContext()
                .map(context -> context.getAuthentication())
                .flatMap(authentication -> {
                    // 从 Authentication 中提取用户信息
                    if (authentication != null && authentication.isAuthenticated()) {
                        String user = authentication.getName();
                        JSONObject json = JSONObject.parseObject(user);
                        if (json.containsKey("id")) {
                            exchange.getAttributes().put("userId", json.getLongValue("id"));
                        }
                        if (json.containsKey("roleId")) {
                            exchange.getAttributes().put("roleId", json.getLongValue("roleId"));
                        }
                    }
                    return Mono.empty();
                })
                .then(chain.filter(exchange));
    }
}
