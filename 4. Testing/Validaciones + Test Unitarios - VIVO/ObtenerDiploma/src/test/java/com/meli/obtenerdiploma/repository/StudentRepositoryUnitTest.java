package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class StudentRepositoryUnitTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @DisplayName("Should retrieve all students")
    void shouldRetrieveAllStudents() {
        // Arrange & Act
        Set<StudentDTO> students = studentRepository.findAll();
        // Assert
        assertTrue(students.isEmpty());
    }

}
