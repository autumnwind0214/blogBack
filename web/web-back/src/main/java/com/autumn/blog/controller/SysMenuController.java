package com.autumn.blog.controller;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.vo.SysMenuVo;
import com.autumn.blog.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    // 获取动态路由
    @GetMapping("/getAsyncRoutes")
    public Mono<Result<List<SysMenuVo>>> getAsyncRoutes(@RequestAttribute("userId") Long userId) {
        Mono<Result<List<SysMenuVo>>> result = sysMenuService.getAsyncRoutes(userId).map(item -> Result.success(item))
                .defaultIfEmpty(Result.fail());
        return result;
    }

}
