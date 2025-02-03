package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("CU1 - Register student test OK")
    void registerStudentTestOk() {
        StudentDTO studentDTO = new StudentDTO();
        ResponseEntity<?> responseExpected = ResponseEntity.ok(null);

        ResponseEntity<?> response = studentController.registerStudent(studentDTO);

        verify(studentService, times(1)).create(studentDTO);
        assertEquals(responseExpected, response);
    }

    @Test
    @DisplayName("CU2 - Get student information OK")
    void getStudentTestOk() {
        Long id = 25L;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        when(studentService.read(id)).thenReturn(studentDTO);

        StudentDTO response = studentController.getStudent(id);

        assertEquals(studentDTO, response);
    }

    @Test
    @DisplayName("CU2 - Get student information not found")
    void getStudentTestNotFoundException() {
        Long id = 25L;
        when(studentService.read(id)).thenReturn(null);

        StudentDTO response = studentController.getStudent(id);

        assertNull(response);
    }

    @Test
    @DisplayName("CU3 - Modify student information ok test")
    void modifyStudentTestOk() {
        StudentDTO studentDTO = new StudentDTO();
        ResponseEntity<?> expected = ResponseEntity.ok(null);
        ResponseEntity<?> response;

        response = studentController.modifyStudent(studentDTO);

        verify(studentService, times(1)).update(studentDTO);
        assertEquals(expected, response);
    }

    @Test
    @DisplayName("CU4 - Remove student information ok test")
    void removeStudentTestOk() {
        Long id = 15L;
        ResponseEntity<?> expected = ResponseEntity.ok(null);
        ResponseEntity<?> response;

        response = studentController.removeStudent(id);

        verify(studentService, times(1)).delete(id);
        assertEquals(expected, response);
    }

    @Test
    @DisplayName("CU5 - List all students test ok")
    void listStudentsTestOK() {
        Set<StudentDTO> studentDTOS = new HashSet<>();
        studentDTOS.add(new StudentDTO(1L, null, null, null, null));
        studentDTOS.add(new StudentDTO(2L, null, null, null, null));
        studentDTOS.add(new StudentDTO(3L, null, null, null, null));
        studentDTOS.add(new StudentDTO(4L, null, null, null, null));

        when(studentService.getAll()).thenReturn(studentDTOS);

        Set<StudentDTO> response = studentController.listStudents();

        assertFalse(response.isEmpty());
        assertEquals(studentDTOS, response);
    }

    @Test
    @DisplayName("CU5 - List all students empty case")
    void listStudentsTestEmpty() {
        when(studentService.getAll()).thenReturn(new HashSet<>());

        Set<StudentDTO> response = studentController.listStudents();

        assertTrue(response.isEmpty());
    }
}