package com.example.firstcase.filereader.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class FraudEntity {
    @Id
    String user_id;
    @Column
    String lastName;
    @Column
    String firstName;
    @Column
    String lesson_id;
    @Column
    String step_id;
    @Column
    String stepPosition;
    @Column
    String stepURL;
    @Column
    String cheatingProbability;


}
