package com.example.firstcase.students.services;

import com.example.firstcase.rates.services.RateService;
import com.example.firstcase.students.entities.*;
import com.example.firstcase.students.models.StudentRegistrationRequest;
import com.example.firstcase.students.repositories.StudentRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            studentEntity.setStatus(1);
            studentEntity.setEnglishLevel(EnglishLevel.valueOf(request.getEnglishLevel()));

        studentRepository.save(studentEntity);
        rateService.saveRate(studentEntity);

    }

    @Override
    public List<StudentEntity> getAllStudentsForJobOff() {
        List<StudentEntity> al = studentRepository.findAllByComExpEqualsOrderByTotalDesc(ExperienceTime.FROM12MONTH);
        List<StudentEntity> firstHalf = new ArrayList<>();
        int x = al.size()/2 + (al.size()%2) - 1;
        for(int i = 0; i < x; i++){
            firstHalf.add(al.get(i));
        }
        return firstHalf;
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> al = studentRepository.findAllByComExpIsNotAndDiplomaIsNotOrderByTotalDesc(ExperienceTime.FROM12MONTH, false);
        List<StudentEntity> firstHalf = new ArrayList<>();
        int x = al.size()/2 + (al.size()%2) - 1;
        for(int i = 0; i < x; i++){
            firstHalf.add(al.get(i));
        }
        return firstHalf;
    }

    @Override
    public List<StudentEntity> getAllStudentsWithoutDiploma() {
        List<StudentEntity> al = studentRepository.findAllByComExpIsNotOrderByTotalAsc(ExperienceTime.FROM12MONTH);
        List<StudentEntity> firstHalf = new ArrayList<>();
        int x = al.size()/2 + (al.size()%2) - 1;
        for(int i = 0; i < x; i++){
            firstHalf.add(al.get(i));
        }
        return firstHalf;
    }

    @Override
    public void setStatus(Integer status, Long id) {
        studentRepository.setStatus(status, id);
    }
}
