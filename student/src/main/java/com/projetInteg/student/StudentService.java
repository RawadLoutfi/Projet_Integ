package com.projetInteg.student;


import com.projetInteg.evaluation.Evaluation;
import com.projetInteg.studentGroup.StudentGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentConfig studentConfig;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentConfig studentConfig) {
        this.studentRepository = studentRepository;
        this.studentConfig = studentConfig;
    }
    public void registerStudent(StudentRegistrationRequest request) {
        Optional<Student> studentOptional = studentRepository.
                findStudentByEmail(request.email());

        Student student = Student.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .matricule(request.matricule())
                .build();
        StudentGroup studentGroup = studentConfig.restTemplate().getForObject(
                "http://localhost:8080/api/v1/group/{groupId}",StudentGroup.class,
                student.getGroupId()
        );
        if(studentGroup==null){
            throw new IllegalStateException("Group chosen with id: " + student.getGroupId() + " not found");
        }
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Entered email is already taken");
        }
        studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void deleteStudent(Integer id){
        boolean exists = studentRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("The student chosen with this id:  " + id + " does not exist");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Integer studentId, String firstName, String lastName, String email, Long matricule, Integer groupId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exists"));

        if (firstName != null && firstName.length() > 0 && !Objects.equals(firstName, student.getFirstName())) {
            student.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0 && !Objects.equals(lastName, student.getLastName())) {
            student.setLastName(lastName);
        }

        if (groupId != null && !Objects.equals(groupId, student.getGroupId())) {
            student.setGroupId(groupId);
        }

        if (matricule != null && !Objects.equals(matricule, student.getMatricule())) {
            student.setMatricule(matricule);
        }

        if (email != null && email.length() > 0 && !Objects.equals(email, student.getEmail())) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }

    public List<Student> getStudentsByGroupId(Integer groupId){
        return studentRepository.findStudentsByGroupId(groupId);
    }

    @Transactional
    public Double calculateGrade(Integer studentId){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exists"));

        ResponseEntity<Evaluation[]> responseEvaluations = studentConfig.restTemplate().getForEntity(
                "http://EVALUATION/api/v1/evaluation/student/{studentId}",
                Evaluation[].class, student.getId()
        );
        Evaluation[] evaluations = responseEvaluations.getBody();
        List<Double> percentages = new ArrayList<Double>() {{
            add(0.1);
            add(0.15);
            add(0.1);
            add(0.1);
            add(0.2);
            add(0.1);
            add(0.1);
            add(0.15);
        }};
        double grade = 0.0;
        for (int i = 0; i < 8; i++) {
            double tmpGrade = 0;
            assert evaluations != null;
            for (Evaluation evaluation : evaluations) {
                System.out.println(evaluation);
                tmpGrade += evaluation.getAllCriterias().get(i);
            }
            tmpGrade /= evaluations.length;
            grade += tmpGrade * percentages.get(i);
        }
        student.setGrade(grade * 5);
        return student.getGrade();
    }
}
