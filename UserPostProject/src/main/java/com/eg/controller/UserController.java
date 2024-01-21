package com.eg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.model.User;
import com.eg.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService uservice;

	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody User u) {
		User expected = uservice.addUser(u);
		if (expected == null) {
			return new ResponseEntity<>("User already exist!", HttpStatus.OK);
		}
		return new ResponseEntity<>(expected, HttpStatus.OK);
	}
}
