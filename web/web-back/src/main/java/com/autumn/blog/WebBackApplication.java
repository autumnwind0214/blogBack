package com.autumn.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author autumn
 * @description 启动类
 * @date 2024年11月09日
 * @version: 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)// 取消数据源自动配置
@EnableDiscoveryClient
@EnableFeignClients
public class WebBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebBackApplication.class, args);
    }
}
