package com.example.firstcase.rates.services;

import com.example.firstcase.rates.entities.RateEntity;
import com.example.firstcase.rates.repositories.RateRepository;
import com.example.firstcase.students.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RateServiceImpl implements RateService {
    @Autowired
    RateRepository rateRepository;

    @Override
    public void saveRate(StudentEntity studentEntity) {
        RateEntity rateEntity = new RateEntity();
        rateEntity.setStudentEntity(studentEntity);
        if (studentEntity.isDiploma()) rateEntity.setDiploma((byte) 1) ;

        if (studentEntity.getComExp().name().equals(ExperienceTime.F1TO6MONTH.name()))
            rateEntity.setComExp((byte) 1);
        else if (studentEntity.getComExp().name().equals(ExperienceTime.F6TO12MONTH.name()))
            rateEntity.setComExp((byte) 2);
        else if(studentEntity.getComExp().name().equals(ExperienceTime.NO.name()) )
                rateEntity.setComExp((byte) 0);

//

        if (studentEntity.getProgramming().name().equals(StudyTime.F1TO6MONTH.name()))
            rateEntity.setProgrammingExperience((byte) 1);
        else if (studentEntity.getProgramming().name().equals(StudyTime.F6TO12MONTH.name()))
            rateEntity.setProgrammingExperience((byte) 2);
        else if(studentEntity.getProgramming().name().equals(StudyTime.NO.name()) )
            rateEntity.setProgrammingExperience((byte) 0);
        else if(studentEntity.getProgramming().name().equals(StudyTime.FROM12MONTH.name()) )
            rateEntity.setProgrammingExperience((byte) 3);

//

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

        rateEntity.setTotal(rateEntity.getDiploma() +
                            rateEntity.getProgrammingExperience() +
                            rateEntity.getComExp() +
                            rateEntity.getProgrammingParticipation() +
                            rateEntity.getMajorIT() +
                            rateEntity.getEnglishLevel()
                            );
        rateRepository.save(rateEntity);
    }


}





