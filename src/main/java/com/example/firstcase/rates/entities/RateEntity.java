package com.example.firstcase.rates.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RateEntity {
    @Id
    Long id;
    @Column
    String email;
    @Column
    String phoneNumber;
    @Column
    String city;
    @Column
    boolean diploma;
    @Column
    String technicalSkills;
    @Column
    byte englishLevel;
    @Column
    int workExperience;
    @Column
    int programmingExperience;
    @Column
    int coursesExperience;

}
