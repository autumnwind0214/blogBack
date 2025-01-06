package com.autumn.blog.gateway.controller;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author autumn
 * @description TODO
 * @date 2025年01月05日
 * @version: 1.0
 */
@RestController
public class AuthController {

    @GetMapping("/token")
    @ResponseBody
    public OAuth2AuthorizedClient token(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient oAuth2AuthorizedClient) {
        // oAuth2AuthorizedClient 对象获取到客户端和令牌相关的信息，然后直接返回给前端页面
        return oAuth2AuthorizedClient;
    }
}
