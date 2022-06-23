package com.example.firstcase.students.services;

import com.example.firstcase.rates.services.RateService;
import com.example.firstcase.students.entities.*;
import com.example.firstcase.students.models.StudentRegistrationRequest;
import com.example.firstcase.students.repositories.StudentRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<StudentEntity> getAllStudentsForJobOff(Integer offset, Integer limit) {
        Pageable paging = PageRequest.of(offset, limit);
        Page<StudentEntity> pagedResult =studentRepository.findAll(paging);
        return pagedResult.toList().stream().filter(c -> c.getComExp() == ExperienceTime.FROM12MONTH).collect(Collectors.toList());
    }

    @Override
    public List<StudentEntity> getAllStudents(Integer offset, Integer limit) {
        Pageable paging = PageRequest.of(offset, limit);
        Page<StudentEntity> pagedResult =studentRepository.findAll(paging);
        return pagedResult.toList().stream().filter(c -> c.getComExp() != ExperienceTime.FROM12MONTH).collect(Collectors.toList());
    }

    @Override
    public List<StudentEntity> getAllStudentsWithoutDiploma(Integer offset, Integer limit) {
        Pageable paging = PageRequest.of(offset, limit);
        Page<StudentEntity> pagedResult =studentRepository.findAll(paging);
        return pagedResult.toList().stream().filter(c -> c.getComExp() != ExperienceTime.FROM12MONTH && !c.isDiploma()).collect(Collectors.toList());
    }
}
