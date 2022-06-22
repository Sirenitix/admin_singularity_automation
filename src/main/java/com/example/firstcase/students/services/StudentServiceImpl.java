package com.example.firstcase.students.services;

import com.example.firstcase.students.entities.StudentEntity;
import com.example.firstcase.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void saveStudent(StudentEntity studentEntity) {
        studentRepository.save(studentEntity);
    }
}
