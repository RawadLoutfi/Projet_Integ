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
