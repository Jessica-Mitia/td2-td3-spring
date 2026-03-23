package org.example.td2td3spring.repository;

import org.example.td2td3spring.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> students;

    public StudentRepository(List<Student> students) {
        this.students = students;
    }

    public List<Student> findAll() {
        return students;
    }

    public void save(Student student) {
        students.add(student);
    }
}
