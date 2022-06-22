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
    Boolean comExp;
    @Column
    ExperienceTime programming_exp;
    @Column
    boolean programmingParticipation;
    @Column
    Stack stack;
    @Column
    boolean majorIT;
    @Column
    EnglishLevel englishLevel;




}
