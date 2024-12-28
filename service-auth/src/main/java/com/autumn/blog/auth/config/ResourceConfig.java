package com.autumn.blog.auth.config;

import com.autumn.blog.auth.authorization.handler.LoginFailureHandler;
import com.autumn.blog.auth.authorization.handler.LoginSuccessHandler;
import com.autumn.blog.auth.property.CustomSecurityProperties;
import com.autumn.blog.auth.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.web.filter.CorsFilter;

/**
 * @author autumn
 * @description 资源服务器配置
 * @date 2024年12月28日
 * @version: 1.0
 */
@EnableWebSecurity
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
@EnableMethodSecurity(jsr250Enabled = true, securedEnabled = true)
public class ResourceConfig {

    // private final CorsFilter corsFilter;

    /**
     * 不需要认证即可访问的路径
     */
    private final CustomSecurityProperties customSecurityProperties;

    /**
     * 配置认证相关的过滤器链(资源服务，客户端配置)
     *
     * @param http spring security核心配置类
     * @return 过滤器链
     * @throws Exception 抛出
     */
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // 添加基础的认证配置
        SecurityUtils.applyBasicSecurity(http, customSecurityProperties);

        http.authorizeHttpRequests((authorize) -> authorize
                        // 放行静态资源和不需要认证的url
                        .requestMatchers(customSecurityProperties.getIgnoreUriList().toArray(new String[0])).permitAll()
                        .anyRequest().authenticated()
                )
                // 指定登录页面
                .formLogin(formLogin -> {
                            formLogin.loginPage("/login");
                            if (UrlUtils.isAbsoluteUrl(customSecurityProperties.getLoginUrl())) {
                                // 绝对路径代表是前后端分离，登录成功和失败改为写回json，不重定向了
                                formLogin.successHandler(new LoginSuccessHandler());
                                formLogin.failureHandler(new LoginFailureHandler());
                            }
                        }
                );
        return http.build();
    }

}
