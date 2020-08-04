package com.hjc.sharding.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "druid")
public class DruidConfig {
    private String filters;
    private Integer maxActive;
    private Integer initialSize;
    private Integer maxWait;
    private Integer minIdle;
    private Integer timeBetweenEvictionRunsMillis;
    private Integer minEvictableIdleTimeMillis;
    private String validationQuery;
    private Boolean testWhileIdle;
    private Boolean testOnBorrow;
    private Boolean testOnReturn;
    private Integer maxOpenPreparedStatements;
    private Boolean removeAbandoned;
    private Boolean logAbandoned;
}
