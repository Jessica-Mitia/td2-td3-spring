package org.example.td2td3spring.controller;

import org.example.td2td3spring.entity.Student;
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
    public ResponseEntity<List<Student>> createStudent(@RequestBody List<Student> students) {
        studentService.saveStudents(students);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.studentService.getAllStudents());
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(@RequestHeader(value = "Accept", required = false) String accept) {
        List<Student> students = studentService.getAllStudents();
        if (accept == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (accept.equalsIgnoreCase("application/json") || accept.equalsIgnoreCase("text/plain")) {
            return new ResponseEntity<>(students, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
