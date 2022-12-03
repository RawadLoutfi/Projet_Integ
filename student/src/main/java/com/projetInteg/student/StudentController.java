package com.projetInteg.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/students")
public record StudentController(StudentService studentService) {
    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.registerStudent(student);
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Integer studentId,
            @RequestBody Student student) {
        studentService.updateStudent(
                studentId,
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getMatricule(),
                student.getGroupId()
        );
    }
    @GetMapping(path = "/grade/{studentId}")
    public Double getGrade(@PathVariable("studentId") Integer studentId){
        return studentService.calculateGrade(studentId);
    }
    @GetMapping(path = "/group/{groupId}")
    public List<Student> getStudentsByGroupId(@PathVariable("groupId") Integer groupId){
        return studentService.getStudentsByGroupId(groupId);
    }

}
