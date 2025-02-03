package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentRepositoryTest {
    private IStudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("US1 - Find All students")
     void findAllTestOk() {
        Set<StudentDTO> studentDTOS;

        studentDTOS = studentRepository.findAll();

        assertNotNull(studentDTOS);
    }

    @Test
    @DisplayName("US1 - Find all students file not found exception")
    void findAllTestFileNotFoundException() {
        Set<StudentDTO> studentDTOS;

        studentDTOS = studentRepository.findAll();

        assertTrue(studentDTOS.isEmpty());
    }
}