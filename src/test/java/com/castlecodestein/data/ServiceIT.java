package com.castlecodestein.data;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.castlecodestein.data.course.Course;
import com.castlecodestein.data.course.CourseRepository;
import com.castlecodestein.data.course.CourseService;
import com.castlecodestein.data.student.Student;
import com.castlecodestein.data.student.StudentRepository;
import com.castlecodestein.data.student.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class, loader = AnnotationConfigContextLoader.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ServiceIT {

	@Inject
	StudentService studentService;
	
	@Inject
	CourseService courseService;
	
	@Inject
	StudentRepository studentRepository;
	
	@Inject
	CourseRepository courseRepository;
	
	@Test
	public void addStudentToCourse() throws Exception {
		Student albert = this.studentService.createStudent("Albert", "Einstein");
		Course physics = this.courseService.createCourse("Physics");
		this.courseService.addStudent(physics, albert);
		
		Student retrieved = this.studentRepository.findOne(albert.getId());
		
		assertEquals(1, retrieved.getCourses().size());
		assertEquals(physics, retrieved.getCourses().iterator().next());
	}
	
}
