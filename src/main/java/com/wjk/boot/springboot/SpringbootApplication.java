package com.wjk.boot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

/*@ComponentScan("com.wjk.boot.springboot")
@EnableAutoConfiguration*/

/**
 * @SpringBootApplication
 * 该注解指定项目为springboot，由此类当作程序入口
         自动装配 web 依赖的环境
         添加 @EnableCaching 注解，开启缓存功能。
 * @author h
 *
 */
@ServletComponentScan //注解Servlet，filter,listener
@EnableCaching
@SpringBootApplication
public class SpringbootApplication {

	/**
	 * application-dev.properties：用于开发环境
application-test.properties：用于测试环境
application-prod.properties：用于生产环境
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
