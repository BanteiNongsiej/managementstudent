package com.example.managementstudent.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long student_id;
	private String student_name;
	private String class_name; 
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name="subject_id")
	private Subject subject;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Long getStudentId() {
		return student_id;
	}

	public void setStudentId(Long student_id) {
		this.student_id = student_id;
	}

	public String getStudentName() {
		return student_name;
	}

	public void setStudentName(String student_name) {
		this.student_name = student_name;
	}

	public String getClassName() {
		return class_name;
	}

	public void setClassName(String class_name) {
		this.class_name = class_name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
