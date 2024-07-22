package com.example.managementstudent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.managementstudent.Model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
