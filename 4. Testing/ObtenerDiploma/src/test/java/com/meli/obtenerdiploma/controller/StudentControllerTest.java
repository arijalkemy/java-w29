package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    Set<StudentDTO> students;
    StudentDTO studentJuan;
    StudentDTO studentPedro;

    @BeforeEach
    void setUp() {
        students = new HashSet<>();

        SubjectDTO math = new SubjectDTO("Matematicas", 9.5);
        SubjectDTO literature = new SubjectDTO("Literatura", 8.8);
        SubjectDTO chemistry = new SubjectDTO("Química", 5.8);

        studentJuan = new StudentDTO(1L,
                "Juan",
                null,
                null, List.of(math, literature));

        studentPedro = new StudentDTO(2L,
                "Pedro",
                null,
                null, List.of(chemistry, math));

        students.add(studentJuan);
        students.add(studentPedro);
    }

    @Test
    void registerStudent() {
        // Arrange

        // Act
        ResponseEntity<?> response = studentController.registerStudent(studentJuan);

        // Assert
        verify(studentService, times(1)).create(studentJuan);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void getStudent() {
        // Arrange
        Long studentId = 1L;

        // Act
        when(studentService.read(studentId)).thenReturn(studentJuan);
        StudentDTO studentResponseDTO = studentController.getStudent(studentId);

        // Assert
        assertEquals(studentJuan, studentResponseDTO);
    }

    @Test
    void modifyStudent() {
        // Arrange

        // Act
        var response = studentController.modifyStudent(studentJuan);

        // Assert
        verify(studentService, times(1)).update(studentJuan);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void removeStudent() {
        Long studentId = 1L;

        var response = studentController.removeStudent(studentId);

        verify(studentService, times(1)).delete(studentId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void listStudents() {

        when(studentService.getAll()).thenReturn(students);
        Set<StudentDTO> studentsResponse = studentController.listStudents();

        assertEquals(students, studentsResponse);

    }
}