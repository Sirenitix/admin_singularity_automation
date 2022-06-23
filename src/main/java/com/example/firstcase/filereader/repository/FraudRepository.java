package com.example.firstcase.filereader.repository;

import com.example.firstcase.filereader.entities.FraudEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FraudRepository extends JpaRepository<FraudEntity,String> {
    List<FraudEntity> findAll();
}
