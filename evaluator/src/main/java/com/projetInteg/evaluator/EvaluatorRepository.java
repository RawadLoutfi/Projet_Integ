package com.projetInteg.evaluator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EvaluatorRepository extends JpaRepository<Evaluator, Integer> {

    @Query("SELECT e FROM Evaluator e WHERE e.email = ?1")
    Optional<Evaluator> findEvaluatorByEmail(String email);

}
