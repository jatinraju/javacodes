package com.eg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eg.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
