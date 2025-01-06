package com.autumn.blog.system.client;

import com.autumn.blog.model.vo.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author autumn
 * @description 远程调用
 * @date 2024年11月15日
 * @version: 1.0
 */
@Service
public class SysMenuFeignClient {

    private final WebClient webClient;

    @Autowired
    public SysMenuFeignClient(WebClient.Builder webClientBuilder) {
        // 设置基础 URL
        this.webClient = webClientBuilder.baseUrl("http://service-system").build();
    }

    public Flux<SysMenuVo> getAsyncRoutes(Long userId){
        Flux<SysMenuVo> resultFlux = webClient.get()
                .uri("/menu/getAsyncRoutes/"+userId)
                .retrieve()
                .bodyToFlux(SysMenuVo.class)
                .onErrorReturn(new SysMenuVo());
        return resultFlux;
    }
}
