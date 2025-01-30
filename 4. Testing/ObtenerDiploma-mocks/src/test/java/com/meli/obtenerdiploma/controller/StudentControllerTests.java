package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    private final Long STUDENT_ID1 = 0L;
    private final String STUDENT_NAME1 = "Matías";
    private final String STUDENT_MESSAGE1 = "Mensaje descriptivo";
    private final Double STUDENT_AVG_SCORE1 = 5.0;

    private final List<SubjectDTO> SUBJECTS1 = List.of(
            new SubjectDTO("Subject 1", 2.0),
            new SubjectDTO("Subject 2", 8.0));

    private final Long STUDENT_ID2 = 0L;
    private final String STUDENT_NAME2 = "Lucas";
    private final String STUDENT_MESSAGE2 = "Mensaje descriptivo2";
    private final Double STUDENT_AVG_SCORE2 = 5.0;

    private final List<SubjectDTO> SUBJECTS2 = List.of(
            new SubjectDTO("Subject 1", 2.0),
            new SubjectDTO("Subject 2", 8.0));


    @Test
    void registerStudent_ValidStudent_ReturnsOk() {
        // 1. Arrange
        StudentDTO student = new StudentDTO(STUDENT_ID1, STUDENT_NAME1, STUDENT_MESSAGE1, STUDENT_AVG_SCORE1, SUBJECTS1);

        // 2. Act
        ResponseEntity<?> response = studentController.registerStudent(student);

        // 3. Assert
        verify(studentService, times(1)).create(student);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void getStudent_ExistingId_ReturnsStudent() {
        // 1. Arrange
        StudentDTO expectedStudent = new StudentDTO(STUDENT_ID1, STUDENT_NAME1, STUDENT_MESSAGE1, STUDENT_AVG_SCORE1, SUBJECTS1);
        when(studentService.read(STUDENT_ID1)).thenReturn(expectedStudent);

        // 2. Act
        StudentDTO result = studentController.getStudent(STUDENT_ID1);

        // 3. Assert
        assertNotNull(result);
        assertEquals(expectedStudent.getId(), result.getId());
        assertEquals(expectedStudent.getStudentName(), result.getStudentName());
        verify(studentService, times(1)).read(STUDENT_ID1);
    }

    @Test
    void modifyStudent_ValidStudent_ReturnsOk() {
        // Arrange
        StudentDTO student = new StudentDTO(STUDENT_ID1, STUDENT_NAME1, STUDENT_MESSAGE1, STUDENT_AVG_SCORE1, SUBJECTS1);

        // Act
        ResponseEntity<?> response = studentController.modifyStudent(student);

        // Assert
        verify(studentService, times(1)).update(student);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void removeStudent_ExistingId_ReturnsOk() {
        // 1. Arrange
        Long id = 1L;

        // 2. Act
        ResponseEntity<?> response = studentController.removeStudent(id);

        // 3. Assert
        verify(studentService, times(1)).delete(id);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void listStudents_ReturnsAllStudents() {
        // 1. Arrange
        StudentDTO student1 = new StudentDTO(STUDENT_ID1, STUDENT_NAME1, STUDENT_MESSAGE1, STUDENT_AVG_SCORE1, SUBJECTS1);
        StudentDTO student2 = new StudentDTO(STUDENT_ID2, STUDENT_NAME2, STUDENT_MESSAGE2, STUDENT_AVG_SCORE2, SUBJECTS2);
        Set<StudentDTO> expectedStudents = Set.of(
                student1,
                student2
        );
        when(studentService.getAll()).thenReturn(expectedStudents);

        // 2. Act
        Set<StudentDTO> result = studentController.listStudents();

        // 3. Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(student1));
        assertTrue(result.contains(student2));
        verify(studentService, times(1)).getAll();
    }
}