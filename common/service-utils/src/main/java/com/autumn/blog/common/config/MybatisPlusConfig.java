package com.autumn.blog.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author autumn
 * @description MybatisPlus配置类
 * @date 2024年11月15日
 * @version: 1.0
 */
// @EnableTransactionManagement
// @Configuration
// @MapperScan("com.autumn.blog.mapper")
public class MybatisPlusConfig {

    /**
     *
     * @return
     */
    // @Bean
    // public MybatisPlusInterceptor optimisticLockerInnerInterceptor(){
    //     MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    //     //向Mybatis过滤器链中添加分页拦截器
    //     interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
    //     return interceptor;
    // }

}
