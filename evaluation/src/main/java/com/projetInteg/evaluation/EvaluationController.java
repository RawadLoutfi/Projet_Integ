package com.projetInteg.evaluation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/evaluation")
public class EvaluationController {
    private final EvaluationService evaluationService;

    @Autowired
    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping(path="student/{studentId}")
    public List<Evaluation> getEvaluationsByStudentId(@PathVariable("studentId") Integer id){
        return evaluationService.getEvaluationsByStudentId(id);
    }

    @PostMapping
    public void addEvaluation(@RequestBody Evaluation evaluation){
        evaluationService.addEvaluation(evaluation);
    }

    @DeleteMapping(path="{evaluationId}")
    public void DeleteEvaluation(@PathVariable("evaluationId") Integer id){
        evaluationService.deleteEvaluation(id);
    }

    @PutMapping(path="{evaluationId}")
    public void updateEvaluation(
            @PathVariable("evaluationId") Integer evaluationId,
            @RequestBody Evaluation evaluation) {
        evaluationService.updateEvaluation(evaluationId,
                evaluation.getCriteria1(),
                evaluation.getCriteria2(),
                evaluation.getCriteria3(),
                evaluation.getCriteria4(),
                evaluation.getCriteria5(),
                evaluation.getCriteria6(),
                evaluation.getCriteria7(),
                evaluation.getCriteria8(),
                evaluation.getCriteria9()
        );
    }
}
