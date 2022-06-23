package com.example.firstcase.tables.entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class TableEntity {
    @Id
    String email;
    @Column
    String stepikID;
    @Column
    String progress;
    @Column
    String progressFull;
    @Column
    String plagiarism;
    @Column
    String flaud;



}
