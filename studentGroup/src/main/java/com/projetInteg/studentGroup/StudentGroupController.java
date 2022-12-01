package com.projetInteg.studentGroup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/studentgroup")
public class StudentGroupController {

    private final StudentGroupService groupService;

    @Autowired
    public StudentGroupController(StudentGroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<StudentGroup> getStudentGroups(){
        return groupService.getStudentGroups();
    }

    @GetMapping(path="{groupId}")
    public Optional<StudentGroup> getStudentGroupById(@PathVariable("groupId") Integer id){
        return groupService.getStudentGroupById(id);
    }
    @PostMapping
    public void addStudentGroup(@RequestBody StudentGroup group){
        groupService.addStudentGroup(group);
    }

    @DeleteMapping(path="{groupId}")
    public void DeleteStudentGroup(@PathVariable("groupId") Integer id){
        groupService.deleteStudentGroup(id);
    }

    @PutMapping(path="{groupId}")
    public void updateStudentGroup(
            @PathVariable("groupId") Integer groupId,
            @RequestBody StudentGroup group) {
        groupService.updateStudentGroup(groupId, group.getFypTitle());

    }
}
