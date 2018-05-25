package com.wjk.boot.springboot.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

	@RequestMapping("/hello")
	public String hello(Map<String,Object> map) {

		map.put("msg", "Hello Freemarker");
		return "hello";
	}
	
	@RequestMapping("/websocket")
	public String websocket() {

		return "websocket";
	}
}