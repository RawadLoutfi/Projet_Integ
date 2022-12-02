package com.projetInteg.evaluation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Evaluation {
    @Id
    @SequenceGenerator(
            name = "evaluation_id_sequence",
            sequenceName = "evaluation_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "evaluation_id_sequence"
    )
    private Integer id;
    private Integer studentId;
    private Integer evaluatorId;
    private Integer criteria1;
    private Integer criteria2;
    private Integer criteria3;
    private Integer criteria4;
    private Integer criteria5;
    private Integer criteria6;
    private Integer criteria7;
    private Integer criteria8;

    private Integer criteria9;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getEvaluatorId() {
        return evaluatorId;
    }

    public void setEvaluatorId(Integer evaluatorId) {
        this.evaluatorId = evaluatorId;
    }

    public Integer getCriteria1() {
        return criteria1;
    }

    public void setCriteria1(Integer criteria1) {
        this.criteria1 = criteria1;
    }

    public Integer getCriteria2() {
        return criteria2;
    }

    public void setCriteria2(Integer criteria2) {
        this.criteria2 = criteria2;
    }

    public Integer getCriteria3() {
        return criteria3;
    }

    public void setCriteria3(Integer criteria3) {
        this.criteria3 = criteria3;
    }

    public Integer getCriteria4() {
        return criteria4;
    }

    public void setCriteria4(Integer criteria4) {
        this.criteria4 = criteria4;
    }

    public Integer getCriteria5() {
        return criteria5;
    }

    public void setCriteria5(Integer criteria5) {
        this.criteria5 = criteria5;
    }

    public Integer getCriteria6() {
        return criteria6;
    }

    public void setCriteria6(Integer criteria6) {
        this.criteria6 = criteria6;
    }

    public Integer getCriteria7() {
        return criteria7;
    }

    public void setCriteria7(Integer criteria7) {
        this.criteria7 = criteria7;
    }

    public Integer getCriteria8() {
        return criteria8;
    }

    public void setCriteria8(Integer criteria8) {
        this.criteria8 = criteria8;
    }

    public Integer getCriteria9() {
        return criteria9;
    }

    public void setCriteria9(Integer criteria9) {
        this.criteria9 = criteria9;
    }

    public List<Integer> getAllCriterias() {
        return new ArrayList<Integer>(){{
            add(criteria1);
            add(criteria2);
            add(criteria3);
            add(criteria4);
            add(criteria5);
            add(criteria6);
            add(criteria7);
            add(criteria8);
        }};
    }

}
