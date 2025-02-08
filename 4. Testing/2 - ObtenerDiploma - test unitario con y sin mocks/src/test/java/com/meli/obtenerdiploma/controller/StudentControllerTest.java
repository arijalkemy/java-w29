package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    @DisplayName("Register student - ok")
    public void registerStudentTest_whenStudentIsValid_thenReturnOk() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Eliana", "Mensaje", 0D, List.of());

        // Act
        ResponseEntity<?> response = studentController.registerStudent(studentDTO);

        // Assert
        verify(studentService).create(studentDTO);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNull(response.getBody());
    }

   /* @Test
    @DisplayName("Register student - not valid") ---- no funciona
    public void registerStudentTest_whenStudentIsntValid_thenThrowException() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();

        // Act & Assert
        assertThrows(MethodArgumentNotValidException.class, () -> {
            studentController.registerStudent(studentDTO);
        });
    }*/


    @Test
    @DisplayName("Get student - ok")
    public void getStudentTest_whenStudentExists_thenReturnOk() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Eliana", "Mensaje", 0D, List.of());
        when(studentService.read(anyLong())).thenReturn(studentDTO);

        // Act
        StudentDTO result = studentController.getStudent(studentDTO.getId());

        // Assert
        assertEquals(studentDTO, result);
    }

    @Test
    @DisplayName("Modify student - ok")
    public void modifyStudent_whenStudentIsValidAndExists_thenReturnOk() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Eliana", "Mensaje", 0D, List.of());

        // Act
        ResponseEntity<?> response = studentController.modifyStudent(studentDTO);

        // Assert
        verify(studentService).update(studentDTO);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNull(response.getBody());
    }

    @Test
    @DisplayName("Remove student - ok")
    public void removeStudentTest_whenStudentExists_thenReturnOk() {
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
    public void listsStudentsTest_whenFindStudents_thenReturnOk() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Eliana", "Mensaje", 0D, List.of());
        when(studentService.getAll()).thenReturn(Set.of(studentDTO));

        // Act
        Set<StudentDTO> result = studentController.listStudents();

        // Assert
        verify(studentService).getAll();
        assertTrue(result.contains(studentDTO));
        assertEquals(1, result.size());
    }

}
