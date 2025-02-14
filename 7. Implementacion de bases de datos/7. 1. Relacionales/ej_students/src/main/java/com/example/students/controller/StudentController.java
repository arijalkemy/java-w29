package com.example.students.controller;

import com.example.students.model.Student;
import com.example.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.getStudent());
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findStudent(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        studentService.saveStudent(student);
        return ResponseEntity.ok(student);
    }
}
