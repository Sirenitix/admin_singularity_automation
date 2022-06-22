package com.example.firstcase.students.controller;

import com.example.firstcase.students.entities.StudentEntity;
import com.example.firstcase.students.models.StudentRegistrationRequest;
import com.example.firstcase.students.services.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    StudentService studentService;

    @PostMapping("/create")
    public String create(@RequestBody StudentRegistrationRequest request) {
        studentService.saveStudent(request);
        return "Student registered";
    }
}
