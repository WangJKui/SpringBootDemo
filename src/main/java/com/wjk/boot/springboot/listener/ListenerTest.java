package com.wjk.boot.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 注册监听器
 * @author h
 *
 */
public class ListenerTest implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("初始化监听器...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	  System.out.println("销毁监听器...");
    }

}
