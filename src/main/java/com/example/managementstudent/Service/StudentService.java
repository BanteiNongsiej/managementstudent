package com.example.managementstudent.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.managementstudent.Model.Student;
import com.example.managementstudent.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Optional<Student> getStudentById(Long id){
		return studentRepository.findById(id);
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student updateStudent(Long id, Student studentDetails) {
		Optional <Student> op=studentRepository.findById(id);
		if(op.isPresent()) {
			Student student=op.get();
			student.setStudentName(studentDetails.getStudentName());
			student.setClassName(studentDetails.getClassName());
			student.setCourse(studentDetails.getCourse());
			student.setSubject(studentDetails.getSubject());
			
			return studentRepository.save(student);
		}else {
			throw new RuntimeException("Student with id "+id+" does not exist");
		}
	}
	
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
