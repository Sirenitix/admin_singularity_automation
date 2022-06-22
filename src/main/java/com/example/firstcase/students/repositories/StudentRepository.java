package com.example.firstcase.students.repositories;

import com.example.firstcase.students.entities.ExperienceTime;
import com.example.firstcase.students.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    List<StudentEntity> findAllByProgrammingEquals(ExperienceTime experienceTime);

    List<StudentEntity> findAllByProgrammingIsNot(ExperienceTime experienceTime);

}
