package com.example.firstcase.students.controller;

import com.example.firstcase.students.entities.StudentEntity;
import com.example.firstcase.students.models.StudentRegistrationRequest;
import com.example.firstcase.students.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public String create(@RequestBody StudentRegistrationRequest request) {
        studentService.saveStudent(request);
        return "Student registered";
    }

    @GetMapping("/students")
    public List<StudentEntity> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/joboffer")
    public List<StudentEntity> getStudentsWithExperience() {
        return studentService.getAllStudentsForJobOff();
    }

    @GetMapping("/dismissed")
    public List<StudentEntity> getStudentsWithoutDiploma() {
        return studentService.getAllStudentsWithoutDiploma();
    }

    @PostMapping("/status")
    public String setStatus(@RequestParam Long id, @RequestParam Integer status) {
        studentService.setStatus(status, id);
        return "Success";
    }

}
