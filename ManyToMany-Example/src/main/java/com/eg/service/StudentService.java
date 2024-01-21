package com.eg.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.model.Course;
import com.eg.model.Student;
import com.eg.repo.CourseRepo;
import com.eg.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo srepo;

	@Autowired
	private CourseRepo crepo;

	public Student addStudent(Student s) {
		Student stu = getStudentByRn(s.getRollno());
		if (stu == null) {
			srepo.save(s);
			return s;
		}

		List<Course> clist = s.getCourses();
		clist.forEach((cour) -> {
			stu.getCourses().add(cour);
		});
		srepo.save(stu);
		return s;
	}

	public Student getStudent(int id) {
		Optional<Student> op = srepo.findById(id);
		if (op.isEmpty()) {
			return null;
		}
		return op.get();
	}

	public Student getStudentByRn(int rn) {
		List<Student> s = srepo.findByRollno(rn);
		if (s.isEmpty()) {

			return null;
		}
		Student stu = new Student();

		stu.setSid(s.get(0).getSid());
		stu.setRollno(s.get(0).getRollno());
		stu.setSname(s.get(0).getSname());

		List<Course> clist = new ArrayList<>();

		Iterator<Student> itr = s.iterator();
		while (itr.hasNext()) {
			List<Course> cc = itr.next().getCourses();
			cc.forEach(cour -> clist.add(cour));
		}

		stu.setCourses(clist);
		return stu;
	}

	public Student deleteCourseStudent(int rn, int cid) {

		Student stu = getStudentByRn(rn);
		if (stu == null) {
			return null;
		}
		boolean isFound = false;
		List<Course> clist = stu.getCourses().stream().filter((cour) -> cour.getCourseid() != cid)
				.collect(Collectors.toList());
		if (clist.isEmpty()) {
			return null;
		}

		stu.setCourses(clist);
		srepo.save(stu);
		// course remains in the table.. it will delete only the relation
		return stu;
	}
}
