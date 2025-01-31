package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentRepositoryTest {

    private String SCOPE;
    private IStudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository();
        SCOPE = "main";
    }

    @Test
    @DisplayName("Find all students")
    void testFindAll() {
        // Arrange
        Set<StudentDTO> loadedData;

        // Act
        loadedData = studentRepository.findAll();

        // Assert
        assertNotNull(loadedData);
    }

    @Test
    void findAll_ShouldReturnExpectedStudents() throws IOException {
        // Arrange
        String jsonPath = "./src/" + SCOPE + "/resources/users.json";
        File testFile = new File(jsonPath);
        ObjectMapper objectMapper = new ObjectMapper();
        Set<StudentDTO> expectedStudents = objectMapper.readValue(testFile, new TypeReference<Set<StudentDTO>>() {});

        // Act
        Set<StudentDTO> actualStudents = studentRepository.findAll();

        // Assert
        assertNotNull(actualStudents, "No se obtuvieron estudiantes.");
        assertEquals(expectedStudents.size(), actualStudents.size(), "El número de estudiantes no coincide.");
//        assertEquals(expectedStudents, actualStudents, "Los estudiantes no coinciden.");
    }
}
