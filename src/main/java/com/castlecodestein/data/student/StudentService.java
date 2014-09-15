package com.castlecodestein.data.student;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

	private final StudentRepository repository;

	@Inject
	public StudentService(StudentRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Transactional
	public Student createStudent(String firstName, String lastName) {
		Student student = Student.of(firstName, lastName);
		return this.repository.save(student);
	}
	
	
}
