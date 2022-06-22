package com.example.firstcase.students.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "student")
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
