package com.eg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eg.model.Person;
import com.eg.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService pservice;

	@PostMapping("/add")
	public ResponseEntity<?> addPerson(@RequestBody Person p) {
		Person expected = pservice.addPerson(p);
		return new ResponseEntity<>(expected, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		List<Person> personList = pservice.getAllPersons();
		return new ResponseEntity<>(personList, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getPerson(@PathVariable("id") int pid) {
		Person expected = pservice.getById(pid);
		if (expected == null) {
			return new ResponseEntity<>("No Person Found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(expected, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<?> deletePerson(@PathVariable("pid") int pid) {
		Person expected = pservice.deletePerson(pid);
		if (expected == null) {
			return new ResponseEntity<>("No Person Found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(expected, HttpStatus.OK);
	}

	@PutMapping("/update/{pid}")
	public ResponseEntity<?> updatePerson(@PathVariable("pid") int pid, @RequestBody Person p) {
		Person expected = pservice.updatePerson(pid, p);
		if (expected == null) {
			return new ResponseEntity<>("No Person Found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(expected, HttpStatus.OK);
	}
}
