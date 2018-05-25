package com.wjk.boot.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController  注释告诉Spring将结果字符串直接呈现给调用者。
 * @author h
 *
 */
@RestController
public class HelloController {

	@RequestMapping("/index")
	public String getIndex() {
		return "index";
	}
	@RequestMapping("/index1")
	public String getIndex1() {
		return "index1";
	}
}
