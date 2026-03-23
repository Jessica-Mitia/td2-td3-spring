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
        try {
            studentService.saveStudents(students);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(studentService.getAllStudents());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents(@RequestHeader(value = "Accept", required = false) String accept) {
        try {
            if (accept == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (accept.equalsIgnoreCase("application/json")) {
                return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
            } else if (accept.equalsIgnoreCase("text/plain")) {
                return new ResponseEntity<>(studentService.getAllStudents().toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}