package com.example.firstcase.students.models;

import lombok.Data;


@Data
public class StudentRegistrationRequest {
    String firstName;
    String secondName;
    String lastName;
    String email;
    String phoneNumber;
    String city;
    boolean diploma;
    String technicalSkills;
    byte englishLevel;
    int workExperience;
    int programmingExperience;
    int coursesExperience;
}
