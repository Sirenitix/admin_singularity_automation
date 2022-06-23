package com.example.firstcase.students.services;

import com.example.firstcase.rates.services.RateService;
import com.example.firstcase.students.entities.*;
import com.example.firstcase.students.models.StudentRegistrationRequest;
import com.example.firstcase.students.repositories.StudentRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            studentEntity.setComExp(ExperienceTime.valueOf(request.getComExp()));
            studentEntity.setProgramming(StudyTime.valueOf(request.getProgramming()));
            studentEntity.setProgrammingParticipation(request.isProgrammingParticipation());
            studentEntity.setStack(Stack.valueOf(request.getStack()));
            studentEntity.setMajorIT(request.isMajorIT());
            studentEntity.setEnglishLevel(EnglishLevel.valueOf(request.getEnglishLevel()));

        studentRepository.save(studentEntity);
        rateService.saveRate(studentEntity);

    }

    @Override
    public List<StudentEntity> getAllStudentsForJobOff() {
        return studentRepository.findAllByProgrammingEquals(StudyTime.FROM12MONTH);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAllByProgrammingIsNot(StudyTime.FROM12MONTH);
    }

    @Override
    public List<StudentEntity> getAllStudentsWithoutDiploma() {
        return studentRepository.findAllByProgrammingIsNotAndAndDiplomaIsNot(StudyTime.FROM12MONTH,true);
    }
}
