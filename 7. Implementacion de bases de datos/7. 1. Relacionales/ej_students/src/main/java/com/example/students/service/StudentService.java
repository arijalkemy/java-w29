package com.example.students.service;

import com.example.students.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudent();

    void saveStudent(Student student);

    void deleteStudent(Long id);

    Student findStudent(Long id);
}
