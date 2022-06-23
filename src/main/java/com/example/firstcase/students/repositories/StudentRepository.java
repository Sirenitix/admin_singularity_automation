package com.example.firstcase.students.repositories;

import com.example.firstcase.students.entities.ExperienceTime;
import com.example.firstcase.students.entities.StudentEntity;
import com.example.firstcase.students.entities.StudyTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    List<StudentEntity> findAllByComExpEquals(ExperienceTime experienceTime);

    List<StudentEntity> findAllByProgrammingIsNot(ExperienceTime experienceTime);


    List<StudentEntity> findAllByProgrammingIsNotAndDiplomaIs(StudyTime studyTime,Boolean diploma);

}
