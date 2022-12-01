package com.projetInteg.evaluator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/evaluator")
public class EvaluatorController {

    private final EvaluatorService evaluatorService;

    @Autowired
    public EvaluatorController(EvaluatorService evaluatorService) {
        this.evaluatorService = evaluatorService;
    }

    @GetMapping
    public List<Evaluator> getEvaluators(){
        return evaluatorService.getEvaluators();
    }

    @PostMapping
    public void addEvaluator(@RequestBody Evaluator evaluator){
        evaluatorService.addEvaluator(evaluator);
    }

    @DeleteMapping(path="{id}")
    public void DeleteEvaluator(@PathVariable("id") Integer id){
        evaluatorService.deleteEvaluator(id);
    }

    @PutMapping(path="{id}")
    public void updateEvaluator(
            @PathVariable("id") Integer id,
            @RequestBody Evaluator evaluator) {
        evaluatorService.updateEvaluator(id, evaluator.getFirstName(), evaluator.getLastName(), evaluator.getEmail());

    }
}
