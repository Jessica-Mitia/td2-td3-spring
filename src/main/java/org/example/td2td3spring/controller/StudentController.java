package org.example.td2td3spring.controller;


import org.example.td2td3spring.entity.Student;
import org.example.td2td3spring.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        studentService.saveStudents(students);

        return studentService.getAllStudents();
    }

    @GetMapping("/students")
    public String getAllStudents(@RequestHeader(value = "Accept") String accept) {
        if (accept.equals("text/plain")) {
            return studentService.getAllStudents().stream().map(student -> student.getFirstName() + " " + student.getLastName()).collect(Collectors.joining(","));
        }
        throw new UnsupportedOperationException("Format non supporté.");
    }
}
