package com.mab.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * Created by 马斌 on 2018/12/3.
 *
 * 自定义mybatis规则
 *
 * 附：MapperScan批量扫描所有mapper接口
 */
@MapperScan(value = "com.mab.mapper")
@org.springframework.context.annotation.Configuration
public class MybatisConfig {
    //开启驼峰命名法
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer(){
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
