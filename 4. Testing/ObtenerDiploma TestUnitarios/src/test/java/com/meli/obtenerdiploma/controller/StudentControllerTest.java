package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    private IStudentService studentService;
    @InjectMocks
    private StudentController studentController;
    private ObtenerDiplomaExceptionController obtenerDiplomaExceptionController;

    @BeforeEach
    void setUp() {
        obtenerDiplomaExceptionController = new ObtenerDiplomaExceptionController();
    }

    @Test
    @DisplayName("Register student successfully")
    void testRegisterStudentSuccessfully() {
        // Arrange
        List<SubjectDTO> subjectList = List.of(new SubjectDTO("Cálculo Diferencial", 10.0),
                new SubjectDTO("Cálculo Integral", 9.0));

        StudentDTO newStudent = StudentDTO.builder()
                .id(1L)
                .studentName("Juan")
                .subjects(subjectList)
                .averageScore(9.5)
                .build();

        // Act
        ResponseEntity<?> response = studentController.registerStudent(newStudent);

        // Assert
        assertNotNull(response);

        assertEquals(200, response.getStatusCodeValue());

        assertNull(response.getBody());

        verify(studentService, atLeastOnce()).create(newStudent);
    }

    @Test
    @DisplayName("Get student successfully")
    void testGetStudentSuccessfully() {
        // Arrange
        List<SubjectDTO> subjectList = List.of(new SubjectDTO("Cálculo Diferencial", 10.0),
                new SubjectDTO("Cálculo Integral", 9.0));

        StudentDTO existingStudent = StudentDTO.builder()
                .id(1L)
                .studentName("Juan")
                .subjects(subjectList)
                .averageScore(9.5)
                .build();

        // Act
        given(studentService.read(anyLong())).willReturn(existingStudent);

        StudentDTO response = studentController.getStudent(existingStudent.getId());

        // Assert
        assertNotNull(response);

        assertEquals(existingStudent, response);
    }

    @Test
    @DisplayName("Get student unsuccessfully")
    void testGetStudentUnsuccessfully() {
        // Arrange
        Long nonExistingId = 999L;

        given(studentService.read(anyLong())).willThrow(new StudentNotFoundException(nonExistingId));

        // Act & assert

        try {
            studentController.getStudent(nonExistingId);
        } catch (StudentNotFoundException e) {
            ErrorDTO error = e.getError();

            assertNotNull(error);
            assertEquals("El alumno con Id 999 no se encuetra registrado.", error.getDescription());

            ResponseEntity<ErrorDTO> responseEntity = obtenerDiplomaExceptionController.handleStudentNotFoundException(e);

            assertNotNull(responseEntity);
            assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
            assertNotNull(responseEntity.getBody());
            assertEquals("StudentNotFoundException", responseEntity.getBody().getName());
            assertNull(responseEntity.getBody().getDescription());
        }
    }

    @Test
    @DisplayName("Modify student successfully")
    void testModifyStudentSuccessfully() {
        // Arrange
        List<SubjectDTO> subjectList = List.of(new SubjectDTO("Cálculo Diferencial", 10.0),
                new SubjectDTO("Cálculo Integral", 9.0));

        StudentDTO studentToModify = StudentDTO.builder()
                .id(1L)
                .studentName("Juan")
                .subjects(subjectList)
                .averageScore(9.5)
                .build();

        // Act
        ResponseEntity<?> response = studentController.modifyStudent(studentToModify);

        // Assert
        assertNotNull(response);

        assertEquals(200, response.getStatusCodeValue());

        assertNull(response.getBody());

        verify(studentService, atLeastOnce()).update(studentToModify);
    }

    @Test
    @DisplayName("Remove student successfully")
    void testRemoveStudentSuccessfully() {
        // Arrange
        Long existingId = 1L;

        // Act
        ResponseEntity<?> response = studentController.removeStudent(existingId);

        // Assert
        assertNotNull(response);

        assertEquals(200, response.getStatusCodeValue());

        assertNull(response.getBody());

        verify(studentService, atLeastOnce()).delete(existingId);
    }

    @Test
    @DisplayName("Get all students successfully")
    void testGetAllStudentsSuccessfully() {
        // Arrange
        Set<StudentDTO> expectedStudents = new HashSet<>();

        expectedStudents.add(new StudentDTO(1L, "Juan", null, null, null));

        expectedStudents.add(new StudentDTO(2L, "Ana", null, null, null));

        // Act
        when(studentService.getAll()).thenReturn(expectedStudents);

        Set<StudentDTO> response = studentController.listStudents();

        // Assert
        assertNotNull(response);

        assertEquals(expectedStudents, response);
    }
}
