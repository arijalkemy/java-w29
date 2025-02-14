package com.example.students.service;

import com.example.students.exception.NotFoundException;
import com.example.students.model.Student;
import com.example.students.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public List<Student> getStudent() {
        return repository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        repository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Student findStudent(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Student not found"));
    }
}
