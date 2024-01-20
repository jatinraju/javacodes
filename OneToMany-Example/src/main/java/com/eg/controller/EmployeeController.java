package com.eg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eg.model.Employee;
import com.eg.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService eservice;

	@PutMapping("/addemp/{did}")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp, @PathVariable("did") int id) {
		Employee expected = eservice.addEmployee(id, emp);
		if (expected == null) {
			return new ResponseEntity<>("No Department Found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(expected, HttpStatus.OK);
	}

	@GetMapping("/getemp/{eid}")
	public ResponseEntity<?> getEmployee(@PathVariable("eid") int id) {
		Employee expected = eservice.getEmployee(id);
		if (expected == null) {
			return new ResponseEntity<>("No Employee Found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(expected, HttpStatus.OK);
	}

	@DeleteMapping("/deleteemp/{eid}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("eid") int id) {
		Employee expected = eservice.deleteEmployee(id);
		if (expected == null) {
			return new ResponseEntity<>("No Employee Found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(expected, HttpStatus.OK);
	}

//	@GetMapping("/getempwdept/{eid}")
//	public ResponseEntity<?> getEmployeeWithDepartment(@PathVariable("eid") int id) {
//		EmployeWithDept expected = eservice.getEmployeeWithDept(id);
//		if (expected == null) {
//			return new ResponseEntity<>("No Employee Found!", HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(expected, HttpStatus.OK);
//	}

}
