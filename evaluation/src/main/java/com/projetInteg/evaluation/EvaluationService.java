package com.projetInteg.evaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    @Autowired
    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public List<Evaluation> getEvaluationsByStudentId(Integer id){
        return evaluationRepository.findByStudentId(id);
    }

    public void addEvaluation(Evaluation evaluation){
        evaluationRepository.save(evaluation);
    }

    public void deleteEvaluation(Integer evaluationId){
        boolean exists = evaluationRepository.existsById(evaluationId);
        if(!exists) {
            throw new IllegalStateException("Evaluation chosen with id " + evaluationId + " does not exists");
        }
        evaluationRepository.deleteById(evaluationId);
    }

    @Transactional
    public void updateEvaluation(Integer evaluationId, Integer criteria1, Integer criteria2, Integer criteria3,
                                 Integer criteria4, Integer criteria5, Integer criteria6,
                                 Integer criteria7,Integer criteria8, Integer criteria9) {
        Evaluation evaluation = evaluationRepository.findById(evaluationId)
                .orElseThrow(() -> new IllegalStateException("Evaluation with id " + evaluationId + " does not exists"));

        if (criteria1 != null && !Objects.equals(criteria1, evaluation.getCriteria1())) {
            evaluation.setCriteria1(criteria1);
        }

        if (criteria2 != null && !Objects.equals(criteria2, evaluation.getCriteria2())) {
            evaluation.setCriteria2(criteria2);
        }

        if (criteria3 != null && !Objects.equals(criteria3, evaluation.getCriteria3())) {
            evaluation.setCriteria3(criteria3);
        }

        if (criteria4 != null && !Objects.equals(criteria4, evaluation.getCriteria4())) {
            evaluation.setCriteria4(criteria4);
        }

        if (criteria5 != null && !Objects.equals(criteria4, evaluation.getCriteria5())) {
            evaluation.setCriteria5(criteria5);
        }

        if (criteria6 != null && !Objects.equals(criteria5, evaluation.getCriteria6())) {
            evaluation.setCriteria6(criteria6);
        }

        if (criteria7 != null && !Objects.equals(criteria6, evaluation.getCriteria7())) {
            evaluation.setCriteria7(criteria7);
        }

        if (criteria8 != null && !Objects.equals(criteria7, evaluation.getCriteria8())) {
            evaluation.setCriteria8(criteria8);
        }

        if (criteria9 != null && !Objects.equals(criteria8, evaluation.getCriteria9())) {
            evaluation.setCriteria9(criteria9);
        }


    }
}
