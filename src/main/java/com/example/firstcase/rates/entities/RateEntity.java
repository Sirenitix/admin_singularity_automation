package com.example.firstcase.rates.entities;

import com.example.firstcase.students.entities.StudentEntity;
import lombok.Data;

import javax.persistence.*;

@Entity (name= "rate")
@Data
public class RateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    @JoinColumn(name = "student_id")
    StudentEntity studentEntity;
    @Column
    byte diploma;
    @Column
    byte programmingExperience;
    @Column
    byte stack;
    @Column
    byte programmingParticipation;
    @Column
    byte majorIT;
    @Column
    byte englishLevel;

}
