package com.projetInteg.studentGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentGroupService {

    private final StudentGroupRepository groupRepository;

    @Autowired
    public StudentGroupService(StudentGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<StudentGroup> getStudentGroups(){
        return groupRepository.findAll();
    }

    public Optional<StudentGroup> getStudentGroupById(Integer groupId){
        return groupRepository.findById(groupId);
    }

    public void addStudentGroup(StudentGroup group){
        groupRepository.save(group);
    }

    public void deleteStudentGroup(Integer groupId){
        boolean exists = groupRepository.existsById(groupId);
        if(!exists) {
            throw new IllegalStateException("group with id " + groupId + " does not exists");
        }
        groupRepository.deleteById(groupId);
    }

    @Transactional
    public void updateStudentGroup(Integer groupId, String fypTitle) {
        StudentGroup group = groupRepository.findById(groupId)
                .orElseThrow(() -> new IllegalStateException("group with id " + groupId + " does not exists"));

        if (fypTitle != null && fypTitle.length() > 0 && !Objects.equals(fypTitle, group.getFypTitle())) {
            group.setFypTitle(fypTitle);
        }
    }
}
