package org.example.td2td3spring.service;

import org.example.td2td3spring.entity.Student;
import org.example.td2td3spring.repository.StudentRepository;
import org.example.td2td3spring.validator.StudentValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentValidator studentValidator;

    public StudentService(StudentRepository studentRepository,
                          StudentValidator studentValidator) {
        this.studentRepository = studentRepository;
        this.studentValidator = studentValidator;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public String getAllStudentsAsText() {
        return studentRepository.findAll().toString();
    }

    public void saveStudents(List<Student> students) {
        for (Student student : students) {
            studentValidator.validate(student);
            studentRepository.save(student);
        }
    }
}
