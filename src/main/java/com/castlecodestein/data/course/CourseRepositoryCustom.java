package com.castlecodestein.data.course;

import java.util.Collection;

public interface CourseRepositoryCustom {

	public Collection<Course> findByTitle(String title);
	
}
