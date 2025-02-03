package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    void givenStudent_whenRegisterStudent_thenStudentIsCreated() {
        StudentDTO student = new StudentDTO(1L, "Andres", null, null, null);
        ResponseEntity<?> response = studentController.registerStudent(student);
        verify(studentService, times(1)).create(student);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void givenExistingStudentId_whenGetStudent_thenReturnStudent() {
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Andres", null, null, null);
        when(studentService.read(studentId)).thenReturn(student);

        StudentDTO resultStudent = studentController.getStudent(studentId);

        assertNotNull(resultStudent);
        assertEquals(student, resultStudent);
    }

    @Test
    void givenUpdatedStudent_whenModifyStudent_thenStudentIsModified() {
        Long studentId = 2L;
        StudentDTO student = new StudentDTO(studentId, "Paula", null, null, null);
        ResponseEntity<?> response = studentController.modifyStudent(student);

        verify(studentService, times(1)).update(student);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void givenExistingStudentId_whenRemoveStudent_thenStudentIsRemoved() {
        Long studentId = 3L;
        ResponseEntity<?> response = studentController.removeStudent(studentId);
        verify(studentService, times(1)).delete(studentId);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void givenStudents_whenGetAll_thenReturnAllStudents() {
        Set<StudentDTO> students = Set.of(
                new StudentDTO(1L, "Andres", null, null, null),
                new StudentDTO(2L, "Laura", null, null, null),
                new StudentDTO(3L, "Pepe", null, null, null)
        );
        when(studentService.getAll()).thenReturn(students);

        Set<StudentDTO> studentsResult = studentController.listStudents();

        assertFalse(studentsResult.isEmpty());
        assertEquals(students, studentsResult);
    }

}
