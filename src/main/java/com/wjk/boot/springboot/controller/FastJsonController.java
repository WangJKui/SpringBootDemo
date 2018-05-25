package com.wjk.boot.springboot.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjk.boot.springboot.vo.User;

/**
 * 开始解决跨域问题
 * 细粒度控制：
 * 在 FastJsonController 类中的方法上添加 @CrossOrigin(origins="xx") 注解：
 * 在使用该注解时，需要注意 @RequestMapping 使用的请求方式类型，即 GET 或 POST。
 * @author h
 *
 */
@CrossOrigin(origins="http://localhost:8088")
@Controller
@RequestMapping("fastjson")
public class FastJsonController {

	@RequestMapping("/test")
	@ResponseBody
	public User test() {
		User user = new User();

		user.setId(110);
		user.setUsername("jack");
		user.setPassword("jack123");
		user.setBirthday(new Date());

		return user;
	}
}
