package com.example.managementstudent.Model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long course_id;
	private String course_name;
	
	@OneToMany(mappedBy="course")
	private List<Student> students;
	
	@ManyToMany
	@JoinTable(
			name="course_subject",
			joinColumns = @JoinColumn(name="course_id"),
			inverseJoinColumns = @JoinColumn(name="subject_id")
	)
	private Set<Subject> subjects;

	public Long getCourseId() {
		return course_id;
	}

	public void setCourseId(Long course_id) {
		this.course_id = course_id;
	}

	public String getCourseName() {
		return course_name;
	}

	public void setCourseName(String course_name) {
		this.course_name = course_name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
}
