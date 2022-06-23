package com.example.firstcase.students.services;

import com.example.firstcase.students.entities.StudentEntity;
import com.example.firstcase.students.models.StudentRegistrationRequest;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentService {
    void saveStudent(StudentRegistrationRequest request);

    List<StudentEntity> getAllStudentsForJobOff();

    List<StudentEntity> getAllStudents();

    List<StudentEntity> getAllStudentsWithoutDiploma();
    void setStatus( Integer status, Long id);
}
