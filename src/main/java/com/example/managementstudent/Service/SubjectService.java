package com.example.managementstudent.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.managementstudent.Model.Subject;
import com.example.managementstudent.Repository.SubjectRepository;

@Service
public class SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;
	
	public Subject createSubject(Subject subject) {
		return subjectRepository.save(subject);
	}
	
	public Optional<Subject> getSubjectById(Long id){
		return subjectRepository.findById(id);
	}
	
	public List<Subject> getAllSubjects(){
		return subjectRepository.findAll();
	}
	
	public Subject updateSubject(Long id , Subject subjectDetails) {
		Optional<Subject> op=subjectRepository.findById(id);
		if(op.isPresent()) {
			Subject subject=op.get();
			subject.setSubjectName(subjectDetails.getSubjectName());
			return subjectRepository.save(subject);
		}else {
			throw new RuntimeException("Subject with id "+id+" does not exist");
		}
	}
	public void deleteSubject(Long id) {
		subjectRepository.deleteById(id);
	}
}
