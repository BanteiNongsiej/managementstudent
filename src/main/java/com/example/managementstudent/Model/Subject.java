package com.example.managementstudent.Model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long subject_id;
	private String subject_name;
	
	@ManyToMany(mappedBy="subjects")
	private List<Course> course;
	
	public Long getSubjectId() {
		return subject_id;
	}

	public void setSubjectId(Long subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubjectName() {
		return subject_name;
	}

	public void setSubjectName(String subject_name) {
		this.subject_name = subject_name;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	
}
