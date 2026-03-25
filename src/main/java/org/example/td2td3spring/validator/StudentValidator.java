package org.example.td2td3spring.validator;

import org.example.td2td3spring.entity.Student;
import org.example.td2td3spring.exception.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class StudentValidator {
    public void validate(Student student) {
        if (student.getLastName() == null || student.getLastName().isBlank()) {
            throw new BadRequestException("Last Name is required");
        }
        if (student.getFirstName() == null || student.getFirstName().isBlank()) {
            throw new BadRequestException("First Name is required");
        }
        if (student.getReference() == null || student.getReference().isBlank()) {
            throw new BadRequestException("Reference is required");
        }
    }
}
