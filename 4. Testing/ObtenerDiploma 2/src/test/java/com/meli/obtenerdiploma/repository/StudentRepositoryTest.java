package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentRepositoryTest {
    @InjectMocks
    StudentRepository studentRepository;


    @Test
    void findAllTest() {
        // Arrange

            Set<StudentDTO> studentsResponse = new HashSet<>();
        studentsResponse.add(new StudentDTO(1L, "juan", null, null, new ArrayList<>()));

        // Act
        Set<StudentDTO> expected = studentRepository.findAll();

        // Assert
        assertEquals(studentsResponse, expected);

    }
}