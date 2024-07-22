package com.example.managementstudent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.managementstudent.Model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

}