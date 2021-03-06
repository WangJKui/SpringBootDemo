package com.wjk.boot.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 自定义Filter
 * 要是该过滤器生效，有两种方式：
	1) 使用 @Component 注解
	2) 添加到过滤器链中，此方式适用于使用第三方的过滤器。将过滤器写到 WebConfig 类中，如下：
 * @author h
 *
 */
@WebFilter(urlPatterns = "/*",filterName = "myFilter")
public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("=======初始化过滤器=========");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		long start = System.currentTimeMillis();

		filterChain.doFilter(request, response);

		System.out.println("filter 耗时：" + (System.currentTimeMillis() - start));

	}

	@Override
	public void destroy() {
		System.out.println("=======销毁过滤器=========");
	}


}
