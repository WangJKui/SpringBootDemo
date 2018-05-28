package com.wjk.boot.springboot.webconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.wjk.boot.springboot.filter.MyFilter;
import com.wjk.boot.springboot.listener.ListenerTest;
import com.wjk.boot.springboot.servlet.ServletTest;

@Configuration
public class WebConfig {

	/**
	 * Fastjson
	 * @return
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

		HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;

		return new HttpMessageConverters(converter);

	}

	/**
	 * 将 Servelt 注册成 Bean。在上文创建的 WebConfig 类中添加如下代码：
	 * @return
	 */
	/*@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new ServletTest(),"/servletTest");
	}*/

	/**
	 * 自定义Filter
	 * 要是该过滤器生效，有两种方式：
		1) 使用 @Component 注解
		2) 添加到过滤器链中，此方式适用于使用第三方的过滤器。将过滤器写到 WebConfig 类中，如下：
	 * @return
	 */
	/*@Bean
	public FilterRegistrationBean timeFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();

		MyFilter myFilter = new MyFilter();
		registrationBean.setFilter(myFilter);

		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);

		return registrationBean;
	}*/

	/**
	 * 注册监听器为 Bean，在 WebConfig 配置类中添加如下代码：
	 * @return
	 */
/*	@Bean
	public ServletListenerRegistrationBean<ListenerTest> servletListenerRegistrationBean() {
		return new ServletListenerRegistrationBean<ListenerTest>(new ListenerTest());
	}*/

	/**
	 * 现在开始解决跨域问题，可以两种维度控制客户端请求。
		粗粒度控制：
		方式一
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/fastjson/**")
				.allowedOrigins("http://localhost:8088");// 允许 8088 端口访问
			}
		};
	}

	/**
	 * WebSocket  方式一：
	 * 该方式只适用于通过 jar 包直接运行项目的情况。
	 * WebSocket 配置类：
	 * @return
	 */
	/*@Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }*/
	
}
