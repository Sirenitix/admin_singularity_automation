package com.example.firstcase.students.entities;

import javax.persistence.*;

@Entity(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String firstName;
    @Column
    String secondName;
    @Column
    String lastName;
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
