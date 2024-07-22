package com.example.managementstudent.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.managementstudent.Model.Course;
import com.example.managementstudent.Model.Student;
import com.example.managementstudent.Model.Subject;
import com.example.managementstudent.Service.CourseService;
import com.example.managementstudent.Service.StudentService;
import com.example.managementstudent.Service.SubjectService;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    
    @Autowired
    CourseService courseService;
    
    @Autowired
    SubjectService subjectService;
    
    @PostMapping("/save")
    public String save(@ModelAttribute("Student") Student student) {
        studentService.createStudent(student);
        return "redirect:/create";
    }
    
    @GetMapping("/create")
    public String create(Model model) {
        Student student = new Student();
        List<Course> listofCourse = courseService.getAllCourses();
        List<Student> students = studentService.getAllStudents();
        
        model.addAttribute("Student", student);
        model.addAttribute("courses", listofCourse);
        model.addAttribute("listofStudent", students);
        
        return "index";
    }
    
    @GetMapping("/subjectList/{course_id}")
    public ResponseEntity<Set<Subject>> getSubjectByCourseId(@PathVariable("course_id") Long courseId) {
        Optional<Course> op = courseService.getCourseById(courseId);
        if (op.isPresent()) {
            Course course = op.get();
            Set<Subject> subjects = course.getSubjects();
            return ResponseEntity.ok(subjects);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Optional<Student> op = studentService.getStudentById(id);
        if (op.isPresent()) {
            Student student = op.get();
            List<Course> listofCourse = courseService.getAllCourses();
            
            model.addAttribute("Student", student);
            model.addAttribute("courses", listofCourse);
            
            return "index"; // Assuming there is an index.html to handle the editing
        } else {
            return "redirect:/create";
        }
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("Student") Student studentDetails) {
        studentService.updateStudent(id, studentDetails);
        return "redirect:/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/create";
    }
    
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "test";
    }
}
