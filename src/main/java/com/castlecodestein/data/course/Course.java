package com.castlecodestein.data.course;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.castlecodestein.data.student.Student;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@Column(name = "c_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURSE_PK_SEQ")
	@SequenceGenerator(name = "COURSE_PK_SEQ", sequenceName = "COURSE_PK_SEQ", allocationSize = 1)
	private Long id;
	@Column(name = "title")
	private String title;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "Courses_Students", joinColumns = @JoinColumn(name = "s_id"), inverseJoinColumns = @JoinColumn(name = "c_id"))
	private Set<Student> students;

	@Deprecated
	Course() {
	}

	Course(Long id, String title, Set<Student> students) {
		super();
		this.id = id;
		this.title = title;
		this.students = students;
	}

	public static Course empty(String title) {
		return new Course(null, title, new HashSet<Student>());
	}

	/* Read */

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Set<Student> getStudents() {
		return ImmutableSet.copyOf(students);
	}

	/* Command */

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public void removeStudent(Student student) {
		this.students.remove(student);
	}

	/* Utility */

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Course)) {
			return false;
		}
		Course course = (Course) obj;
		return this.id.equals(course.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(Course.class).add("id", this.id)
				.add("title", this.title).toString();
	}

}
