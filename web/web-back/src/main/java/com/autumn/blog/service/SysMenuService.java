package com.autumn.blog.service;

import com.autumn.blog.model.vo.SysMenuVo;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
public interface SysMenuService {

    Mono<List<SysMenuVo>> getAsyncRoutes(Long userId);
}
