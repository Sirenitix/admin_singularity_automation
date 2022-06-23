package com.example.firstcase.tables.repository;

import com.example.firstcase.tables.entities.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<TableEntity, String> {
}
