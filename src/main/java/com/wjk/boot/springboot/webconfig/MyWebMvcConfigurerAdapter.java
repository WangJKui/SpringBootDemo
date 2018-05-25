package com.wjk.boot.springboot.webconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.wjk.boot.springboot.interceptor.MyInterceptor;

/**
 * 编写拦截器后，我们还需要将其注册到拦截器链中，如下配置：
 * @author h
 *
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter{
    
    @Autowired
    private MyInterceptor myInterceptor;
    

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor);
    }
    
    /**
	 * 现在开始解决跨域问题，可以两种维度控制客户端请求。
		粗粒度控制：
		方式二
	 */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/fastjson/**")
              .allowedOrigins("http://localhost:8088");// 允许 8088 端口访问
    }

}
