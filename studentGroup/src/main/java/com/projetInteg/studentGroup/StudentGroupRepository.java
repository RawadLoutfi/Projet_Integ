package com.projetInteg.studentGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Integer> {
    @Query("SELECT sg FROM StudentGroup sg where sg.groupId =?1")
    Optional<StudentGroup> findGroupId(Integer groupId);
}
