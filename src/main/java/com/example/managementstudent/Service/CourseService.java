package com.example.managementstudent.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.managementstudent.Model.Course;
import com.example.managementstudent.Repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public Optional<Course> getCourseById(Long id){
		return courseRepository.findById(id);
	}
	
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	public Course updateCourse(Long id, Course courseDetails) {
		Optional<Course> op=courseRepository.findById(id);
		if(op.isPresent()) {
			Course course=op.get();
			course.setCourseName(courseDetails.getCourseName());
			return courseRepository.save(course);
		}else {
			throw new RuntimeException("Course with id "+id+" does not exist");
		}
	}
	
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}
}
