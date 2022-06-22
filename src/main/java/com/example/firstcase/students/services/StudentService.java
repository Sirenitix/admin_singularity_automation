package com.example.firstcase.students.services;

import com.example.firstcase.students.entities.StudentEntity;
import com.example.firstcase.students.models.StudentRegistrationRequest;

public interface StudentService {
    void saveStudent(StudentRegistrationRequest request);

}
