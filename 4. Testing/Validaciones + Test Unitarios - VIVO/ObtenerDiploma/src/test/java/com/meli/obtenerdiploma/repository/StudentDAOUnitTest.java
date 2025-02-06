package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOUnitTest {

    @Autowired
    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        generateJsonFIle();
    }

    @Value("${api.scope}")
    private String SCOPE;

    private void generateJsonFIle() {
        StudentDTO studentDTO = generateStudentDTO();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json");
            objectMapper.writeValue(file, List.of(studentDTO));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        }
    }

    private StudentDTO generateStudentDTO() {
        return new StudentDTO(
                1L,
                "Pepe",
                "Mensaje",
                10.0,
                List.of(
                        new SubjectDTO("CS50", 10.0)
                ));
    }

    @Test
    @DisplayName("Should find student by id")
    void shouldFindStudentByIdTest() {
        // Arrange
        StudentDTO studentDTO = generateStudentDTO();
        studentDTO.setId(2L);
        studentDAO.save(studentDTO);

        // Act
        StudentDTO result = studentDAO.findById(studentDTO.getId());

        // Assert
        Assertions.assertNotNull(studentDTO);
        Assertions.assertEquals(result.getId(), studentDTO.getId());
    }

    @Test
    @DisplayName("Should throw not found exception when not found by id")
    void shouldThrowNotFoundExceptionWhenNotFoundByIdTest() {
        // Arrange
        Long studentId = 999L;

        // Act & Assert
        assertThrows(
                StudentNotFoundException.class,
                () -> studentDAO.findById(studentId)
        );
    }

    @Test
    @DisplayName("Should return true when deleting a student")
    void shouldReturnTrueWhenDeletingStudentTest() {
        // Arrange
        Long studentId = 1L;

        // Act
        boolean result = studentDAO.delete(studentId);

        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Should return true when student exists")
    void shouldReturnTrueWhenStudentExistsTest() {
        // Arrange
        StudentDTO studentDTO = studentDAO.findById(1L);

        // Act
        boolean result = studentDAO.exists(studentDTO);

        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Should return false when student doesn't exist")
    void shouldReturnFalseWhenStudentDoesNotExistsTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(
                999L,
                "Juan",
                "Mensaje",
                10.0,
                List.of()
        );

        // Act
        boolean result = studentDAO.exists(studentDTO);

        // Assert
        assertFalse(result);

    }

}
