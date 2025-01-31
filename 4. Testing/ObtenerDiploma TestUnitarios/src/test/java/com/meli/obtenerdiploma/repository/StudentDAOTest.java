package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    private static IStudentDAO studentDAORepository;

    @BeforeEach
    void setUp() {
        studentDAORepository = new StudentDAO();
    }

    @Test
    @DisplayName("Find StudentDTO by id successfully")
    void testFindById() {
        // Arrange
        Long existingId = 1L;

        // Act
        StudentDTO result = studentDAORepository.findById(existingId);

        // Assert
        assertNotNull(result);
        assertEquals(existingId, result.getId());
    }

    @Test
    @DisplayName("Find StudentDTO by id unsuccessfully")
    void testFindByIdThrowsException() {
        // Arrange
        Long nonExistingId = 4L;

        // Act & assert
        assertThrows(StudentNotFoundException.class, () -> studentDAORepository.findById(nonExistingId));
    }

    @Test
    @DisplayName("Delete() successfully")
    void testDeleteStudentDTO() {
        // Arrange
        Long existingId = 2L;

        // Act
        boolean res = studentDAORepository.delete(existingId);

        // Assert
        assertTrue(res);
    }

    @Test
    @DisplayName("Delete() unsuccessfully")
    void testDeleteStudentDTOThrowsException() {
        // Arrange
        Long nonExistingId = 4L;

        // Act & assert
        assertThrows(StudentNotFoundException.class, () -> studentDAORepository.findById(nonExistingId));
    }

    @Test
    @DisplayName("Exists true")
    void testExistsTrue() {
        // Arrange
        StudentDTO existingStudent = studentDAORepository.findById(1L);

        // Act
        boolean result = studentDAORepository.exists(existingStudent);

        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Exists false")
    void testExistsFalse() {
        // Arrange
        StudentDTO nonExistingStudent = new StudentDTO();

        // Act
        boolean result = studentDAORepository.exists(nonExistingStudent);

        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Save StudentDTO successfully")
    void testSaveSuccessfully() {
        // Arrange
        StudentDTO studentToSave = new StudentDTO();

        // Act
        studentDAORepository.save(studentToSave);

        // Assert
        assertNotNull(studentToSave.getId());
    }

    @Test
    @DisplayName("Save existing StudentDTO successfully")
    void testSaveExistingStudentSuccessfully() {
        // Arrange
        StudentDTO existingStudent = new StudentDTO(2L, null, null, null, null);

        // Act
        studentDAORepository.save(existingStudent);

        // Assert
        assertNotNull(existingStudent.getId());
    }
}
