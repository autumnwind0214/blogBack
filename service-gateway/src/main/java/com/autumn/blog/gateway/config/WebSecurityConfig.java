package com.autumn.blog.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author autumn
 * @description 资源服务器配置
 * @date 2024年12月29日
 * @version: 1.0
 * http://127.0.0.1:9000/auth-api/getCaptcha
 */
@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfig {

    // 配置认证相关的过滤器链
    @Bean
    public SecurityWebFilterChain defaultSecurityFilterChain(ServerHttpSecurity http) {
        // 全部请求都需要认证
        http.authorizeExchange(authorize -> authorize
                .pathMatchers("/auth-api/login", "/auth-api/getCaptcha").permitAll()
                .anyExchange().authenticated()
        )
        ;

        // 开启OAuth2登录
        http.oauth2Login(Customizer.withDefaults());
        http.oauth2Client(Customizer.withDefaults());

        // 禁用csrf与cors
        http.csrf(csrf -> csrf.disable());
        // 启用 CORS 配置
        http.cors(Customizer.withDefaults());
        return http.build();
    }
}
