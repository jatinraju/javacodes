package com.eg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eg.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}