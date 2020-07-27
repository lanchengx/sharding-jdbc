package com.hjc.sharding.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.hjc.sharding.*.mapper*")
public class MybatisPlusConfig {

//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor paginationInterceptor = new CachePaginationInterceptor();
//        paginationInterceptor.setDialectType(DBType.MYSQL.getDb());
//        return paginationInterceptor;
//    }
}
