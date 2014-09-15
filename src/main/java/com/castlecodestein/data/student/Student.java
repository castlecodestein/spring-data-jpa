package com.castlecodestein.data.student;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.castlecodestein.data.course.Course;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;

@Entity
@Table(name="Students")
public class Student {

	@Id
	@Column(name = "s_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_PK_SEQ")
	@SequenceGenerator(name = "STUDENT_PK_SEQ", sequenceName = "STUDENT_PK_SEQ", allocationSize = 1)
	private Long id;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created")
	private Date created;
	@ManyToMany(mappedBy="students", fetch=FetchType.EAGER)
	private Set<Course> courses;

	/* Constructor */
	
	/**
	 * For hibernate only.
	 */
	@Deprecated
	Student() {
	}
	
	Student(Long id, String firstName, String lastName, Date created, Set<Course> courses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = created;
		this.courses = courses;
	}

	/* Factory */
	
	public static Student of(String firstName, String lastName) {
		return new Student(null, firstName, lastName, new Date(), new HashSet<Course>());
	}
	
	/* Read */

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getCreated() {
		return created;
	}
	
	public Set<Course> getCourses() {
		return ImmutableSet.copyOf(courses);
	}
	
	/* Utility */

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student student = (Student) obj;
		return this.id.equals(student.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(Course.class).add("id", this.id)
				.add("firstName", this.firstName).add("lastName", this.lastName).toString();
	}
	
}
