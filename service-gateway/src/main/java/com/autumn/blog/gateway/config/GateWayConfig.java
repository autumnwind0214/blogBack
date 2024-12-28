package com.autumn.blog.gateway.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author autumn
 * @description TODO
 * @date 2024年12月28日
 * @version: 1.0
 */
@Configuration
public class GateWayConfig {
    @Bean
    public GlobalFilter customCorsFilter() {
        return (exchange, chain) -> {
            ServerHttpResponse response = exchange.getResponse();
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                List<String> varyHeaders = response.getHeaders().get("Vary");
                if (varyHeaders != null && !varyHeaders.isEmpty()) {
                    // 去重处理
                    Set<String> uniqueVaryHeaders = new HashSet<>(varyHeaders);
                    response.getHeaders().set("Vary", String.join(", ", uniqueVaryHeaders));
                }
            }));
        };
    }
}
