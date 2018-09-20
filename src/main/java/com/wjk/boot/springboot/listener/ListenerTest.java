package com.wjk.boot.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 注册监听器
 * @author h
 *
 */
@WebListener
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
