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
    String city;
    @Column
    boolean diploma;
    @Column(name = "programming_exp")
    ExperienceTime programming;
    @Column
    Stack stack;
    @Column
    boolean programmingParticipation;
    @Column
    boolean majorIT;
    @Column
    EnglishLevel englishLevel;

}
