package com.wjk.boot.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 使用 @Component，@Aspect 标记到切面类上：
 * @author h
 *
 */
@Aspect
@Component
public class MyAspect {
	
	@Around("execution(* com.wjk.boot.springboot.controller.FastJsonController..*(..))")
	public Object method(ProceedingJoinPoint pjp) throws Throwable {

		System.out.println("=====Aspect处理=======");
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			System.out.println("参数为:" + arg);
		}

		long start = System.currentTimeMillis();

		Object object = pjp.proceed();

		System.out.println("Aspect 耗时:" + (System.currentTimeMillis() - start));

		return object;
	}
}
