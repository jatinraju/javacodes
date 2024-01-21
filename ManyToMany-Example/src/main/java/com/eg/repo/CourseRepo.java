package com.eg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eg.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

	public void deleteByCourseid(int courseid);
}
