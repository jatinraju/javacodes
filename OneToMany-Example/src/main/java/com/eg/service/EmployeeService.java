package com.eg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.model.Department;
import com.eg.model.Employee;
import com.eg.repo.DepartmentRepo;
import com.eg.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private DepartmentRepo drepo;

	@Autowired
	private EmployeeRepo erepo;

	@Autowired
	private DepartmentService dser;

	public Employee addEmployee(int did, Employee e) {
		Department d = dser.getDepartment(did);
		if (d == null) {
			return null;
		}
		d.getEmployee().add(e);
		drepo.save(d);

		return e;
	}

	public Employee getEmployee(int eid) {
		Optional<Employee> op = erepo.findById(eid);
		if (op.isEmpty()) {
			return null;
		}
		return op.get();
	}

	public Employee deleteEmployee(int eid) {
		Employee e = getEmployee(eid);
		if (e == null) {
			return null;
		}
		erepo.deleteById(eid);
		return e;
	}

	// get employee with department detail
//	public EmployeWithDept getEmployeeWithDept(int eid) {
//		EmployeWithDept emp = erepo.findByEid(eid);
//		return emp;
//	}
}
