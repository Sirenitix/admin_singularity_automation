package com.example.firstcase.rates.repositories;

import com.example.firstcase.rates.entities.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<RateEntity,Long> {
}
