package com.example.firstcase.students.services;

import com.example.firstcase.rates.services.RateService;
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
        studentEntity.setStack(request.getStack());
        studentEntity.setProgrammingParticipation(request.isProgrammingParticipation());
        studentEntity.setMajorIT(request.isMajorIT());
        studentEntity.setEnglishLevel(request.getEnglishLevel());
        studentEntity.setComExp(request.getComExp());
        rateService.saveRate(studentEntity);
        studentRepository.save(studentEntity);
    }
}
