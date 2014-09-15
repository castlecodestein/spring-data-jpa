package com.castlecodestein.data.course;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.castlecodestein.data.student.Student;

@Service
public class CourseService {

	private final CourseRepository repository;

	@Inject
	public CourseService(CourseRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Transactional
	public Course createCourse(String title) {
		Course course = Course.empty(title);
		return this.repository.save(course);
	}
	
	@Transactional
	public void addStudent(Course course, Student student) {
		course.addStudent(student);
		this.repository.save(course);
	}
	
}
