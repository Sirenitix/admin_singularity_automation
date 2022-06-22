package com.example.firstcase.students.services;

import com.example.firstcase.students.entities.StudentEntity;
import com.example.firstcase.students.models.StudentRegistrationRequest;
import com.example.firstcase.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void saveStudent(StudentRegistrationRequest request) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(request.getFirstName());
        studentEntity.setLastName(request.getLastName());
        studentEntity.setSecondName(request.getSecondName());
        studentEntity.setCity(request.getCity());
        studentEntity.setDiploma(request.isDiploma());
        studentEntity.setEmail(request.getEmail());
        studentEntity.setCoursesExperience(request.getCoursesExperience());
        studentEntity.setEnglishLevel(request.getEnglishLevel());
        studentEntity.setPhoneNumber(request.getPhoneNumber());
        studentEntity.setProgrammingExperience(request.getProgrammingExperience());
        studentEntity.setWorkExperience(request.getWorkExperience());
        studentEntity.setTechnicalSkills(request.getTechnicalSkills());

        studentRepository.save(studentEntity);
    }
}
