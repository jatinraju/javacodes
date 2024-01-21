package com.eg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eg.model.Student;
import com.eg.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService sser;

	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody Student s) {
		Student expected = sser.addStudent(s);
		return new ResponseEntity<>(expected, HttpStatus.OK);
	}

	@GetMapping("/get/{sid}")
	public ResponseEntity<?> getStudent(@PathVariable("sid") int id) {
		Student expected = sser.getStudent(id);
		if (expected == null) {
			return new ResponseEntity<>("No Student Found!", HttpStatus.OK);
		}
		return new ResponseEntity<>(expected, HttpStatus.OK);
	}

	@GetMapping("/getrn/{rn}")
	public ResponseEntity<?> getStudentByRollNo(@PathVariable("rn") int rn) {
		Student expected = sser.getStudentByRn(rn);
		if (expected == null) {
			return new ResponseEntity<>("No Student Found!", HttpStatus.OK);
		}
		return new ResponseEntity<>(expected, HttpStatus.OK);
	}

	@DeleteMapping("/deletec/{rn}/{cid}")
	public ResponseEntity<?> getStudentByRollNo(@PathVariable("rn") int rn, @PathVariable("cid") int cid) {
		Student expected = sser.deleteCourseStudent(rn, cid);
		if (expected == null) {
			return new ResponseEntity<>("No Student or Course Found!", HttpStatus.OK);
		}
		return new ResponseEntity<>(expected, HttpStatus.OK);
	}
}
