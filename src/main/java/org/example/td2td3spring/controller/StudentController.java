package org.example.td2td3spring.controller;

import org.example.td2td3spring.entity.Student;
import org.example.td2td3spring.exception.BadRequestException;
import org.example.td2td3spring.exception.NotImplementedException;
import org.example.td2td3spring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public ResponseEntity<?> createStudent(@RequestBody List<Student> students) {
        studentService.saveStudents(students);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/students", produces = {"application/json", "text/plain"})
    public ResponseEntity<?> getAllStudents(@RequestHeader(value = "Accept", required = false) String accept) {
        if (accept == null) {
            throw new BadRequestException("Accept header is required");
        }
        if (accept.equalsIgnoreCase("application/json")) {
            return ResponseEntity.ok(studentService.getAllStudents());
        }
        if (accept.equalsIgnoreCase("text/plain")) {
            return ResponseEntity.ok(studentService.getAllStudentsAsText());
        }
        throw new NotImplementedException("Format not supported");
    }
}