package com.eg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

	@RequestMapping("/hello")
	public String getHello() {
		return "Hello From Public Controller";
	}
}
