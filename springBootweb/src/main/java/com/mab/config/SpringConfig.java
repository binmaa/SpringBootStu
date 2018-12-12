package com.mab.config;

import com.mab.component.LocaleResolver;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 马斌 on 2018/10/22.
 * 使用WebMvcConfigurerAdapter扩展springBoot的功能
 */
//@EnableWebMvc
@Configuration
public class SpringConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        //浏览器发送请求springConfig到succeed页面
        registry.addViewController("/springConfig").setViewName("succeed");
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            //注册视图映射
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                super.addViewControllers(registry);
                registry.addViewController("/").setViewName("Login");
                registry.addViewController("/login").setViewName("Login");
                registry.addViewController("/index").setViewName("Login");
                registry.addViewController("/main").setViewName("dashboard");
                registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors(registry);
                //springboot已经做好了静态资源映射
//                registry.addInterceptor(new LoginHanderInterceptor()).addPathPatterns("/**").excludePathPatterns
//                        ("/login","/index","/","/user/Login");
            }
        };
        return adapter;
    }

    @Bean
    public org.springframework.web.servlet.LocaleResolver localeResolver() {
        return new LocaleResolver();
    }

}
