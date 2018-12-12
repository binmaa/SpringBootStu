package com.mab.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by 马斌 on 2018/11/7.
 */
public class listener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.print("contextDestroyed...web容器销毁");
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.print("contextInitialized...web容器启动");
    }
}
