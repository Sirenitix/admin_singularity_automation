package com.example.firstcase.students.models;

import lombok.Data;


@Data
public class StudentRegistrationRequest {

    String fullName;
    String email;
    String phoneNumber;
    boolean diploma;
    String comExp;
    String programming;
    boolean programmingParticipation;
    String stack;
    boolean majorIT;
    String englishLevel;
}
