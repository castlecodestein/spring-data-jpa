package com.castlecodestein.data.course;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CourseRepositoryCustomImpl implements CourseRepositoryCustom {

	@PersistenceContext
	EntityManager em;

	@Override
	public Collection<Course> findByTitle(String title) {
		return em.createQuery("from Course c where c.title = ?1", Course.class)
				.setParameter(1, title).getResultList();
	}

}
