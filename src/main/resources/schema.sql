create table Students ( 
	s_id int8 not null PRIMARY KEY,
	firstName varchar(30) not null,
	lastName varchar(30) not null,
	created timestamp not null
);

create table Courses (
	c_id int8 not null PRIMARY KEY,
	title varchar(40) not null
);

create table Courses_Students (
	c_id int8,
	s_id int8,
	UNIQUE (c_id, s_id)
);

alter table Courses_Students 
	add constraint FK_Courses_Students_Course
	foreign key (c_id) 
	references Courses;
	
alter table Courses_Students 
	add constraint FK_Courses_Students_Student
	foreign key (s_id) 
	references Students;

create sequence STUDENT_PK_SEQ;
create sequence COURSE_PK_SEQ;