package com.example.firstcase.rates.services;

import com.example.firstcase.rates.entities.RateEntity;
import com.example.firstcase.rates.repositories.RateRepository;
import com.example.firstcase.students.entities.EnglishLevel;
import com.example.firstcase.students.entities.ExperienceTime;
import com.example.firstcase.students.entities.Stack;
import com.example.firstcase.students.entities.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RateServiceImpl implements RateService {
    @Autowired
    RateRepository rateRepository;

    @Override
    public void saveRate(StudentEntity studentEntity) {
        RateEntity rateEntity = new RateEntity();
        rateEntity.setStudentEntity(studentEntity);
        if (studentEntity.isDiploma()) rateEntity.setDiploma((byte) 1);

        if (studentEntity.getProgramming().equals(ExperienceTime.F1TO3MONTH))
            rateEntity.setProgrammingExperience((byte) 1);
        else if (studentEntity.getProgramming().equals(ExperienceTime.F3TO6MONTH))
            rateEntity.setProgrammingExperience((byte) 2);
        else if (studentEntity.getProgramming().equals(ExperienceTime.F6TO12MONTH))
            rateEntity.setProgrammingExperience((byte) 3);
        else rateEntity.setProgrammingExperience((byte) 0);

        if (studentEntity.getStack().equals(Stack.C))
            rateEntity.setStack((byte) 1);
        else if (studentEntity.getStack().equals(Stack.CPLUS))
            rateEntity.setStack((byte) 1);
        else if (studentEntity.getStack().equals(Stack.GO))
            rateEntity.setStack((byte) 2);
        else if (studentEntity.getStack().equals(Stack.JAVA))
            rateEntity.setStack((byte) 5);
        else if (studentEntity.getStack().equals(Stack.LINUX))
            rateEntity.setStack((byte) 1);
        else if (studentEntity.getStack().equals(Stack.PYTHON))
            rateEntity.setStack((byte) 3);
        else if (studentEntity.getStack().equals(Stack.SQL))
            rateEntity.setStack((byte) 2);
        else rateEntity.setStack((byte) 0);

        if (studentEntity.isProgrammingParticipation()) rateEntity.setProgrammingParticipation((byte) 1);
        if (studentEntity.isMajorIT()) rateEntity.setMajorIT((byte) 1);


        if (studentEntity.getEnglishLevel().equals(EnglishLevel.ELEMENTARY)) rateEntity.setEnglishLevel((byte) 1);
        else if (studentEntity.getEnglishLevel().equals(EnglishLevel.INTERMEDIATE))
            rateEntity.setEnglishLevel((byte) 2);
        else if (studentEntity.getEnglishLevel().equals(EnglishLevel.UPPERINTERMEDIATE))
            rateEntity.setEnglishLevel((byte) 3);
        else if (studentEntity.getEnglishLevel().equals(EnglishLevel.ADVANCED)) rateEntity.setEnglishLevel((byte) 4);
        else if (studentEntity.getEnglishLevel().equals(EnglishLevel.PROFICIENT)) rateEntity.setEnglishLevel((byte) 5);
        else rateEntity.setEnglishLevel((byte) 0);

        rateRepository.save(rateEntity);
    }
}





