package com.eg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/normal")
public class NormalController {

	@RequestMapping("/hello")
	public String getHello() {
		return "Hello From Normal Controller";
	}
}
