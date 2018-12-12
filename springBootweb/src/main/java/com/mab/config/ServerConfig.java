package com.mab.config;

import com.mab.filter.filter;
import com.mab.listener.listener;
import com.mab.servlert.Servlert;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by 马斌 on 2018/11/6.
 */
@Configuration
public class ServerConfig {
    /**
     * 三大组件
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new Servlert(),"/servlert");
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new filter());
        filter.setUrlPatterns(Arrays.asList("/hello","/servlert"));
        return filter;
    }
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean<listener> registrationBean = new ServletListenerRegistrationBean<listener>
                (new listener());
        return registrationBean;
    }

    /**
     *定制嵌入式的servlet容器
     * @return
     */
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            /**定制嵌入式的servlet容器相关规则**/
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
//                container.setPort(8083);
            }
        };
    }
}
