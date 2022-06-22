package com.example.firstcase.students.models;

import com.example.firstcase.students.entities.EnglishLevel;
import com.example.firstcase.students.entities.ExperienceTime;
import com.example.firstcase.students.entities.Stack;
import lombok.Data;

import javax.persistence.Column;


@Data
public class StudentRegistrationRequest {

    String fullName;
    String email;
    String phoneNumber;
    boolean diploma;
    @Column (name = "programming_exp")
    ExperienceTime programming;
    Boolean comExp;
    Stack stack;
    boolean programmingParticipation;
    boolean majorIT;
    EnglishLevel englishLevel;
}
