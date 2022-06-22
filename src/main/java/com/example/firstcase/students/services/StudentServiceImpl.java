package com.example.firstcase.students.services;

import com.example.firstcase.rates.services.RateService;
import com.example.firstcase.students.entities.EnglishLevel;
import com.example.firstcase.students.entities.ExperienceTime;
import com.example.firstcase.students.entities.Stack;
import com.example.firstcase.students.entities.StudentEntity;
import com.example.firstcase.students.models.StudentRegistrationRequest;
import com.example.firstcase.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    RateService rateService;

    @Override
    public void saveStudent(StudentRegistrationRequest request) {

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setFullName(request.getFullName());
        studentEntity.setEmail(request.getEmail());
        studentEntity.setPhoneNumber(request.getPhoneNumber());
        studentEntity.setDiploma(request.isDiploma());
        studentEntity.setComExp(request.getComExp());
        studentEntity.setProgramming(request.getProgramming());
        studentEntity.setProgrammingParticipation(request.isProgrammingParticipation());
        studentEntity.setStack(request.getStack());
        studentEntity.setMajorIT(request.isMajorIT());
        studentEntity.setEnglishLevel(request.getEnglishLevel());

        rateService.saveRate(studentEntity);
        studentRepository.save(studentEntity);
    }
}
