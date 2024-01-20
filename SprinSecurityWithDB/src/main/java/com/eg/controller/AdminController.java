package com.eg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/hello")
	public String getHello() {
		return "Hello From Admin Controller";
	}
}