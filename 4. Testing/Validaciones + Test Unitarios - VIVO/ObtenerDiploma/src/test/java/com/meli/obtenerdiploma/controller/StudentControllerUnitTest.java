package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerUnitTest {
    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    @DisplayName("Should save a user test")
    public void shouldSaveUserTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Mensaje", 0D, List.of());

        // Act
        ResponseEntity<?> response = studentController.registerStudent(studentDTO);

        // Assert
        verify(studentService).create(studentDTO);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNull(response.getBody());
    }

    @Test
    @DisplayName("should find student by id test")
    public void shouldFindStudentByIdTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Mensaje", 0D, List.of());
        when(studentService.read(anyLong())).thenReturn(studentDTO);

        // Act
        StudentDTO result = studentController.getStudent(studentDTO.getId());

        // Assert
        assertEquals(studentDTO, result);
    }

    @Test
    @DisplayName("should modify a student test")
    public void shouldModifyStudentTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Mensaje", 0D, List.of());

        // Act
        ResponseEntity<?> response = studentController.modifyStudent(studentDTO);

        // Assert
        verify(studentService).update(studentDTO);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNull(response.getBody());
    }

    @Test
    @DisplayName("should remove a student test")
    public void shouldRemoveStudentTest() {
        // Arrange
        Long studentId = 1L;

        // Act
        ResponseEntity<?> response = studentController.removeStudent(studentId);

        // Assert
        verify(studentService).delete(studentId);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNull(response.getBody());
    }

    @Test
    @DisplayName("should list all students test")
    public void shouldListAllStudentsTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Pepe", "Mensaje", 0D, List.of());
        when(studentService.getAll()).thenReturn(Set.of(studentDTO));

        // Act
        Set<StudentDTO> result = studentController.listStudents();

        // Assert
        verify(studentService).getAll();
        assertTrue(result.contains(studentDTO));
        assertEquals(1, result.size());
    }

}
