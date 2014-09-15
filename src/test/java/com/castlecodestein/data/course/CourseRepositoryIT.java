package com.castlecodestein.data.course;

import static org.junit.Assert.*;

import java.util.Collection;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.castlecodestein.data.SpringConfiguration;
import com.castlecodestein.data.student.Student;
import com.castlecodestein.data.student.StudentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class, loader = AnnotationConfigContextLoader.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CourseRepositoryIT {

	@Inject
	CourseRepository repository;
	
	@Inject
	CourseService service;
	
	@Test
	public void entitySave() throws Exception {
		Course entity = Course.empty("Quantum Mechanics");
		
		repository.save(entity);
		
		Course retrieved = repository.findOne(1l);
		
		assertNotNull(retrieved.getId());
		assertEquals("Quantum Mechanics", retrieved.getTitle());
		assertEquals(0, retrieved.getStudents().size());
		assertEquals(1, repository.findAll().size());
	}
	
	@Test
	public void customRepositoryImplementation() throws Exception {
		this.service.createCourse("Physics");
		
		Collection<Course> retrieved = this.repository.findByTitle("Physics");
		
		assertEquals(1, retrieved.size());
		
	}
	
}
