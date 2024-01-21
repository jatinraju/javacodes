package com.eg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eg.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	@Query("select s from Student s where s.rollno = ?1")
	public List<Student> findByRollno(int rn);
}
