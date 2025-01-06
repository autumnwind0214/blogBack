package com.autumn.blog.service.impl;

import com.autumn.blog.common.exception.AutumnException;
import com.autumn.blog.common.result.Result;
import com.autumn.blog.common.result.ResultCodeEnum;
import com.autumn.blog.common.util.AuthContextHolder;
import com.autumn.blog.model.dto.MenuDto;
import com.autumn.blog.model.dto.SelectIdsDto;
import com.autumn.blog.model.vo.*;
import com.autumn.blog.service.SysMenuService;
import com.autumn.blog.system.client.SysMenuFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuFeignClient sysMenuFeignClient;

    @Override
    public Mono<List<SysMenuVo>> getAsyncRoutes(Long userId) {
        Flux<SysMenuVo> asyncRoutes = sysMenuFeignClient.getAsyncRoutes(userId);
        return asyncRoutes.collectList();
    }
}
