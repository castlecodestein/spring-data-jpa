package com.castlecodestein.data.course;

import org.springframework.stereotype.Repository;

import com.castlecodestein.data.repository.CriteriaRepository;

@Repository
public interface CourseRepository extends CriteriaRepository<Course>, CourseRepositoryCustom {

}
