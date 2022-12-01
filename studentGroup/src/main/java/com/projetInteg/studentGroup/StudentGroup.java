package com.projetInteg.studentGroup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class StudentGroup {

    @Id
    @SequenceGenerator(
            name = "studentGroup_id_sequence",
            sequenceName = "studentGroup_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "studentGroup_id_sequence"
    )
    private Integer groupId;
    private String fypTitle;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getFypTitle() {
        return fypTitle;
    }

    public void setFypTitle(String fypTitle) {
        this.fypTitle = fypTitle;
    }
}
