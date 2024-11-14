package com.autumn.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author autumn
 * @description 启动类
 * @date 2024年11月09日
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class, args);
    }
}
