package com.example.demoJpa.service;

import com.example.demoJpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
}
