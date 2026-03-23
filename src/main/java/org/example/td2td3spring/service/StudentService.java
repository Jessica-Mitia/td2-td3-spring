package org.example.td2td3spring.service;

import org.example.td2td3spring.entity.Student;
import org.example.td2td3spring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudents(List<Student> students) {
        for (Student student : students) {
            this.studentRepository.save(student);
        }
    }
}
