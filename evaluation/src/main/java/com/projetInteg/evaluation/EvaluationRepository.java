package com.projetInteg.evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {
    @Query("SELECT e FROM Evaluation e where e.studentId = ?1")
    List<Evaluation> findByStudentId(Integer studentId);

}
