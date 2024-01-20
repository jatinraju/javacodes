package com.eg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eg.model.Department;
import com.eg.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService dservice;

	@PostMapping("/add")
	public ResponseEntity<?> addDepartment(@RequestBody Department d) {
		Department expected = dservice.addDepartment(d);
		return new ResponseEntity<>(expected, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAllDepartments() {
		List<Department> dlist = dservice.getAllDepartments();
		return new ResponseEntity<>(dlist, HttpStatus.OK);
	}

	@GetMapping("/get/{did}")
	public ResponseEntity<?> getDepartment(@PathVariable("did") int id) {
		Department expected = dservice.getDepartment(id);
		if (expected != null) {
			return new ResponseEntity<>(expected, HttpStatus.OK);
		}
		return new ResponseEntity<>("Department Not Found!", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{did}")
	public ResponseEntity<?> deleteDepartment(@PathVariable("did") int id) {
		Department expected = dservice.deleteDepartment(id);
		if (expected != null) {
			return new ResponseEntity<>(expected, HttpStatus.OK);
		}
		return new ResponseEntity<>("Department Not Found!", HttpStatus.OK);
	}

}
