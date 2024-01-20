package com.eg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.model.Department;
import com.eg.repo.DepartmentRepo;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo drepo;

	public Department addDepartment(Department d) {
		drepo.save(d);
		return d;
	}

	public List<Department> getAllDepartments() {
		return drepo.findAll();
	}

	public Department getDepartment(int id) {
		Optional<Department> op = drepo.findById(id);
		if (op.isEmpty()) {
			return null;
		}

		return op.get();
	}

	public Department deleteDepartment(int id) {
		Department d = getDepartment(id);
		if (d != null) {
			drepo.deleteById(id);
			return d;
		}
		return null;
	}

}
