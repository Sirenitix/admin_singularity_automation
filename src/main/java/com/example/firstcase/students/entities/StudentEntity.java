package com.example.firstcase.students.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "student")
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String fullName;
    @Column
    String email;
    @Column
    String phoneNumber;
    @Column
    boolean diploma;
    @Column
    StudyTime comExp;
    @Column(name = "programming_exp")
    ExperienceTime programming;
    @Column
    boolean programmingParticipation;
    @Column
    Stack stack;
    @Column
    boolean majorIT;
    @Column
    EnglishLevel englishLevel;

}
