package com.example.firstcase.students.repositories;

import com.example.firstcase.students.entities.StudentEntity;
import com.example.firstcase.students.entities.StudyTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    List<StudentEntity> findAllByProgrammingIsNotOrderByTotalDesc(StudyTime experienceTime);

    List<StudentEntity> findAllByProgrammingEqualsOrderByTotalDesc(StudyTime from12month);

    List<StudentEntity> findAllByProgrammingIsNotAndAndDiplomaIsNotOrderByTotalDesc(StudyTime from12month, boolean b);

    @Transactional
    @Modifying
    @Query(value = "update student  set status = ?1 where id = ?2", nativeQuery = true)
    void setStatus(Integer status, Long id);


    @Transactional
    @Modifying
    @Query(value = "update student  set total = ?1 where id = ?2", nativeQuery = true)
    void setTotal(Integer total, Long id);
}
