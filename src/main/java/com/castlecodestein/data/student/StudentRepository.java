package com.castlecodestein.data.student;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.castlecodestein.data.repository.CriteriaRepository;

/**
 * Repository for Student objects.
 * <br/>
 * <br/>
 * @Query is used to specify a JPQL query to be executed. Native queries can be enabled with nativeQuery parameter.
 * @author Tomasz Krug
 *
 */
@Repository
public interface StudentRepository extends CriteriaRepository<Student> {

	@Query("from Student s where s.lastName = ?1")
	public Collection<Student> findByLastName(String lastName);

	public Student findById(Long id);
	
}
